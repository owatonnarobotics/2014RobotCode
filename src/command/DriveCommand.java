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
public class DriveCommand extends CommandBase {

    public DriveCommand() {
        requires(drive);
    }
    protected void initialize() {
    }

    protected void execute() {
       drive.execute(oi.getXbox());
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {     
    }

    protected void interrupted() {
    }
    
}
