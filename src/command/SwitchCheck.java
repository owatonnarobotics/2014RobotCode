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
public class SwitchCheck extends CommandBase {

    public SwitchCheck() {
        requires(motor360);
        requires(switch360);
    }
    
    protected void initialize() {
        
    }

    protected void execute() {
        if(switch360.check()) {
            motor360.turnOff();
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
