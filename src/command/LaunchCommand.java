/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import templates.subsystems.Motor360;

/**
 *
 * @author Developer
 */
public class LaunchCommand extends CommandBase {

    boolean completed = false;
    boolean exitedSensor = false;

    public LaunchCommand() {
        requires(motor360);
    }

    protected void initialize() {
        motor360.turnOn();
    }

    protected void execute() {
        if (motor360.check() && exitedSensor) {
            completed = true;
        } else if (!motor360.check()) {
            exitedSensor = true;
        }
    }

    protected boolean isFinished() {
        return completed;
    }

    protected void end() {
        motor360.turnOff();
        launcher.toggleOff();
    }

    protected void interrupted() {
    }
}
