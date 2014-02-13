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
public class TestCommand extends CommandBase{

    public TestCommand() {
        requires(motor360);
    }

    protected void initialize() {
        this.setTimeout(2);
        motor360.turnOn();
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut(  );
    }

    protected void end() {
        motor360.turnOff();
    }

    protected void interrupted() {
    }
}
