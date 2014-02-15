/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.subsystems.FrontSensor;

/**
 *
 * @author Developer
 */
public class FrontSensorToDash extends CommandBase {

    public FrontSensorToDash() {
        requires(distanceSensor);
    }
    
    
    protected void initialize() {
        
    }

    protected void execute() {
        SmartDashboard.putBoolean("Distance: ", distanceSensor.inRange());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
