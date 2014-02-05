/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;

/**
 *
 * @author Developer
 */
public class DetectHotGoal extends CommandBase {

    final int Y_IMAGE_RES = 480;
    final double VIEW_ANGLE = 49;

    final double PI = 3.141592653;

    final int RECTANGULARITY_LIMIT = 40;
    final int ASPECT_RATIO_LIMIT = 55;

    final int TAPE_WIDTH_LIMIT = 50;
    final int VERTICAL_SCORE_LIMIT = 50;
    final int LR_SCORE_LIMIT = 50;

    final int AREA_MINIMUM = 150;
    final int MAX_PARTICLES = 8;

    AxisCamera camera;          // the axis camera object (connected to the switch)
    CriteriaCollection cc;

    protected void initialize() {
        
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }

    public class Scores {

        double rectangularity;
        double aspectRatioVertical;
        double aspectRatioHorizontal;
    }

    public class TargetReport {

        int verticalIndex;
        int horizontalIndex;
        boolean Hot;
        double totalScore;
        double leftScore;
        double rightScore;
        double tapeWidthScore;
        double verticalScore;
    }

    public void robotInit() {
        //camera = AxisCamera.getInstance();  // get an instance of the camera
        cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, AREA_MINIMUM, 65535, false);
    }

    public void autonomous() {
        TargetReport target = new TargetReport();
        int verticalTargets[] = new int[MAX_PARTICLES];
        int horizontalTargets[] = new int[MAX_PARTICLES];
        int verticalTargetCount, horizontalTargetCount;

        try {
            /**
             * Do the image capture with the camera and apply the algorithm
             * described above. This sample will either get images from the
             * camera or from an image file stored in the top level directory in
             * the flash memory on the cRIO. The file name in this case is
             * "testImage.jpg"
             *
             */
            //ColorImage image = camera.getImage();     // comment if using stored images
            ColorImage image;                           // next 2 lines read image from flash on cRIO
            image = new RGBImage("/testImage.jpg");		// get the sample image from the cRIO flash
            BinaryImage thresholdImage = image.thresholdHSV(105, 137, 230, 255, 133, 183);   // keep only green objects
            //thresholdImage.write("/threshold.bmp");
            BinaryImage filteredImage = thresholdImage.particleFilter(cc);           // filter out small particles
            //filteredImage.write("/filteredImage.bmp");

            //iterate through each particle and score to see if it is a target
            Scores scores[] = new Scores[filteredImage.getNumberParticles()];
            horizontalTargetCount = verticalTargetCount = 0;

            if (filteredImage.getNumberParticles() > 0) {
                for (int i = 0; i < MAX_PARTICLES && i < filteredImage.getNumberParticles(); i++) {
                    ParticleAnalysisReport report = filteredImage.getParticleAnalysisReport(i);
                    scores[i] = new Scores();

                    //Score each particle on rectangularity and aspect ratio
                    scores[i].rectangularity = scoreRectangularity(report);
                    scores[i].aspectRatioVertical = scoreAspectRatio(filteredImage, report, i, true);
                    scores[i].aspectRatioHorizontal = scoreAspectRatio(filteredImage, report, i, false);

                    //Check if the particle is a horizontal target, if not, check if it's a vertical target
                    if (scoreCompare(scores[i], false)) {
                        System.out.println("particle: " + i + "is a Horizontal Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                        horizontalTargets[horizontalTargetCount++] = i; //Add particle to target array and increment count
                    } else if (scoreCompare(scores[i], true)) {
                        System.out.println("particle: " + i + "is a Vertical Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                        verticalTargets[verticalTargetCount++] = i;  //Add particle to target array and increment count
                    } else {
                        System.out.println("particle: " + i + "is not a Target centerX: " + report.center_mass_x + "centerY: " + report.center_mass_y);
                    }
                    System.out.println("rect: " + scores[i].rectangularity + "ARHoriz: " + scores[i].aspectRatioHorizontal);
                    System.out.println("ARVert: " + scores[i].aspectRatioVertical);
                }

                //Zero out scores and set verticalIndex to first target in case there are no horizontal targets
                target.totalScore = target.leftScore = target.rightScore = target.tapeWidthScore = target.verticalScore = 0;
                target.verticalIndex = verticalTargets[0];
                for (int i = 0; i < verticalTargetCount; i++) {
                    ParticleAnalysisReport verticalReport = filteredImage.getParticleAnalysisReport(verticalTargets[i]);
                    for (int j = 0; j < horizontalTargetCount; j++) {
                        ParticleAnalysisReport horizontalReport = filteredImage.getParticleAnalysisReport(horizontalTargets[j]);
                        double horizWidth, horizHeight, vertWidth, leftScore, rightScore, tapeWidthScore, verticalScore, total;

                        //Measure equivalent rectangle sides for use in score calculation
                        horizWidth = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
                        vertWidth = NIVision.MeasureParticle(filteredImage.image, verticalTargets[i], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
                        horizHeight = NIVision.MeasureParticle(filteredImage.image, horizontalTargets[j], false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);

                        //Determine if the horizontal target is in the expected location to the left of the vertical target
                        leftScore = ratioToScore(1.2 * (verticalReport.boundingRectLeft - horizontalReport.center_mass_x) / horizWidth);
                        //Determine if the horizontal target is in the expected location to the right of the  vertical target
                        rightScore = ratioToScore(1.2 * (horizontalReport.center_mass_x - verticalReport.boundingRectLeft - verticalReport.boundingRectWidth) / horizWidth);
                        //Determine if the width of the tape on the two targets appears to be the same
                        tapeWidthScore = ratioToScore(vertWidth / horizHeight);
                        //Determine if the vertical location of the horizontal target appears to be correct
                        verticalScore = ratioToScore(1 - (verticalReport.boundingRectTop - horizontalReport.center_mass_y) / (4 * horizHeight));
                        total = leftScore > rightScore ? leftScore : rightScore;
                        total += tapeWidthScore + verticalScore;

                        //If the target is the best detected so far store the information about it
                        if (total > target.totalScore) {
                            target.horizontalIndex = horizontalTargets[j];
                            target.verticalIndex = verticalTargets[i];
                            target.totalScore = total;
                            target.leftScore = leftScore;
                            target.rightScore = rightScore;
                            target.tapeWidthScore = tapeWidthScore;
                            target.verticalScore = verticalScore;
                        }
                    }
                    //Determine if the best target is a Hot target
                    target.Hot = hotOrNot(target);
                }

                if (verticalTargetCount > 0) {
                                    //Information about the target is contained in the "target" structure
                    //To get measurement information such as sizes or locations use the
                    //horizontal or vertical index to get the particle report as shown below
                    ParticleAnalysisReport distanceReport = filteredImage.getParticleAnalysisReport(target.verticalIndex);
                    double distance = computeDistance(filteredImage, distanceReport, target.verticalIndex);
                    if (target.Hot) {
                        System.out.println("Hot target located");
                        System.out.println("Distance: " + distance);
                    } else {
                        System.out.println("No hot target present");
                        System.out.println("Distance: " + distance);
                    }
                }
            }

            /**
             * all images in Java must be freed after they are used since they
             * are allocated out of C data structures. Not calling free() will
             * cause the memory to accumulate over each pass of this loop.
             */
            filteredImage.free();
            thresholdImage.free();
            image.free();

//            } catch (AxisCameraException ex) {        // this is needed if the camera.getImage() is called
//                ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }

    }

    double computeDistance(BinaryImage image, ParticleAnalysisReport report, int particleNumber) throws NIVisionException {
        double rectLong, height;
        int targetHeight;

        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        //using the smaller of the estimated rectangle long side and the bounding rectangle height results in better performance
        //on skewed rectangles
        height = Math.min(report.boundingRectHeight, rectLong);
        targetHeight = 32;

        return Y_IMAGE_RES * targetHeight / (height * 12 * 2 * Math.tan(VIEW_ANGLE * Math.PI / (180 * 2)));
    }

    public double scoreAspectRatio(BinaryImage image, ParticleAnalysisReport report, int particleNumber, boolean vertical) throws NIVisionException {
        double rectLong, rectShort, aspectRatio, idealAspectRatio;

        rectLong = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_LONG_SIDE);
        rectShort = NIVision.MeasureParticle(image.image, particleNumber, false, MeasurementType.IMAQ_MT_EQUIVALENT_RECT_SHORT_SIDE);
        idealAspectRatio = vertical ? (4.0 / 32) : (23.5 / 4);	//Vertical reflector 4" wide x 32" tall, horizontal 23.5" wide x 4" tall

        //Divide width by height to measure aspect ratio
        if (report.boundingRectWidth > report.boundingRectHeight) {
            //particle is wider than it is tall, divide long by short
            aspectRatio = ratioToScore((rectLong / rectShort) / idealAspectRatio);
        } else {
            //particle is taller than it is wide, divide short by long
            aspectRatio = ratioToScore((rectShort / rectLong) / idealAspectRatio);
        }
        return aspectRatio;
    }

    boolean scoreCompare(Scores scores, boolean vertical) {
        boolean isTarget = true;

        isTarget &= scores.rectangularity > RECTANGULARITY_LIMIT;
        if (vertical) {
            isTarget &= scores.aspectRatioVertical > ASPECT_RATIO_LIMIT;
        } else {
            isTarget &= scores.aspectRatioHorizontal > ASPECT_RATIO_LIMIT;
        }

        return isTarget;
    }

    double scoreRectangularity(ParticleAnalysisReport report) {
        if (report.boundingRectWidth * report.boundingRectHeight != 0) {
            return 100 * report.particleArea / (report.boundingRectWidth * report.boundingRectHeight);
        } else {
            return 0;
        }
    }

    double ratioToScore(double ratio) {
        return (Math.max(0, Math.min(100 * (1 - Math.abs(1 - ratio)), 100)));
    }

    boolean hotOrNot(TargetReport target) {
        boolean isHot = true;

        isHot &= target.tapeWidthScore >= TAPE_WIDTH_LIMIT;
        isHot &= target.verticalScore >= VERTICAL_SCORE_LIMIT;
        isHot &= (target.leftScore > LR_SCORE_LIMIT) | (target.rightScore > LR_SCORE_LIMIT);

        return isHot;
    }
}
