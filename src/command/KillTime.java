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
public class KillTime extends CommandBase {

    public KillTime(double stuffedOreos) {
        setTimeout(stuffedOreos);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
