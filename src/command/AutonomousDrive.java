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
class AutonomousDrive extends CommandBase {

    public AutonomousDrive() {
    }

    protected void initialize() {
        requires(drive);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;
        
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}