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
public class CheckLaunchSwitch extends CommandBase{

    protected void initialize() {
        requires(detector);
        requires(launcher);
    }

    protected void execute() {
        if(detector.check()) {
            launcher.toggleOn();
        }
    }

    protected boolean isFinished() {
        return false;
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
