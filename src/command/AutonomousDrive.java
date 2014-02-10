/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Developer
 */
public class AutonomousDrive extends CommandBase {

    public AutonomousDrive() {
        requires(drive);
        requires(frontSensor);
    }

    protected void initialize() {
        drive.forward();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return frontSensor.inOptimalRange();
        
    }

    protected void end() {
        drive.right();
        Timer.delay(.5);
        drive.stop();
    }

    protected void interrupted() {
        
    }
    
}
