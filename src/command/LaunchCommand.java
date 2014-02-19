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

    private boolean completed;
    private boolean exitedSensor;

    public LaunchCommand() {
        System.out.println("Started LaunchCommand.");
        requires(motor360);
    }

    protected void initialize() {
        completed = false;
        exitedSensor = false;
        
        System.out.println("Starting class.");
        motor360.turnOn();
    }

    protected void execute() {
        System.out.println("Switch: " + motor360.check() );
        System.out.println(exitedSensor );
        if (motor360.check() && exitedSensor) {
            System.out.println("Done Rotating.");
            completed = true;
        } else if (!motor360.check()) {
            System.out.println("No longer touching switch.");
            exitedSensor = true;
        }
    }

    protected boolean isFinished() {
        return completed;
    }

    protected void end() {
        System.out.println("Done shooting.");
        motor360.turnOff();
        launcher.toggleOff();
    }

    protected void interrupted() {
    }
}
