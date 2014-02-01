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
public class PassCommand extends CommandBase {

    protected void initialize() {
        requires(grab);
        
    }

    protected void execute() {
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
