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
public class LaunchCommand extends CommandBase {

    protected void initialize() {
        requires(motor360);
        requires(launcher);
    }

    protected void execute() {
        motor360.rotate();
        Timer.delay(.5);
        launcher.toggleOff();
        //What is "switch - when hit turn on" ?
    }

    protected boolean isFinished() {
        return true;
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
