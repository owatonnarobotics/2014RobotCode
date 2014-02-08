/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class DetectHotGoal extends CommandBase {
    
    public DetectHotGoal(){
        requires(camera);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;

    }

    protected void end() {
        camera.getPic();
        camera.processPic();
        RobotMap.hotGoal = camera.getIsHot();
    }

    protected void interrupted() {

    }
}
