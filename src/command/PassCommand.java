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
public class PassCommand extends CommandBase {

    public PassCommand() {
        requires(grab);
        requires(solenoid);
    }
    
    protected void initialize() {
    }

    protected void execute() {
        grab.switchSpin();
        solenoid.toggleOn();
        Timer.delay(.5);
        solenoid.toggleOff();
        grab.switchSpin();
    }

    protected boolean isFinished() {
        return true;
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
       
}
