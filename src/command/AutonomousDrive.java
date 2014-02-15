/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

/**
 *
 * @author Developer
 */
public class AutonomousDrive extends CommandBase {

    public AutonomousDrive() {
        this.setTimeout(4);
        requires(drive);
        requires(distanceSensor);
    }

    protected void initialize() {
        drive.forward();
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return distanceSensor.inRange() || this.isTimedOut();

    }

    protected void end() {
        drive.stop();
    }

    protected void interrupted() {

    }

}
