/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.subsystems.Grabber;

/**
 *
 * @author Developer
 */
public class PassCommand extends CommandBase {
    
    public PassCommand() {
        requires(grab);
        requires(solenoid);
    }

    protected void initialize() {
        setTimeout(3);
        grab.switchSpin();
        solenoid.toggleOn();
        SmartDashboard.putBoolean("Pull On", Grabber.motorOn);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        solenoid.toggleOff();
        grab.switchSpin();
    }

    protected void interrupted() {
        solenoid.toggleOff();
    }

}
