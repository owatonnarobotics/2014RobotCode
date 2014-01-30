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
public class MotorCommandThinger extends CommandBase {
    
    public MotorCommandThinger() {
        requires(oneMotor);
        
    }

    protected void initialize() {
        
    }

    protected void execute() {
        oneMotor.toggle();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
    
}
