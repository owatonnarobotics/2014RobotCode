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
        requires(drive);
        requires(distanceSensor);
    }

    protected void initialize() {
        this.setTimeout(4);
        System.out.println("Executing Drive");
    }

    protected void execute() {
        drive.forward();
    }

    protected boolean isFinished() {
        return this.isTimedOut() || distanceSensor.inAutoRange();
        //return distanceSensor.inAutoRange();
    }

    protected void end() {
        drive.stop();
        System.out.println("Done with Drive");
    }

    protected void interrupted() {
        System.out.println("Interrupted.");
        drive.stop();
    }

}