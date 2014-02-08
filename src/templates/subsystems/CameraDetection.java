/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templates.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVisionException;

/**
 *
 * @author Developer
 */
public class CameraDetection extends Subsystem {
    
    private AxisCamera camera;
    private CriteriaCollection cc;
    ColorImage image;
    
    public void getPic() {
        try {
            image = camera.getImage();
        } catch (AxisCameraException ex) {
            ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
    }
    
    public void processPic() {
        try {
            BinaryImage thresholdImage = image.thresholdRGB(150, 255, 0, 150, 0, 150);
            BinaryImage filteredImage = thresholdImage.particleFilter(cc);
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        }
    }
    
    protected void initDefaultCommand() {
        
    }
    
    
}
