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
public class MotorOn extends CommandBase {

    protected void initialize() {
        requires(motor360);
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        motor360.rotate();
    }

    protected void interrupted() {
        // ethan.turnOff();
    }
}
