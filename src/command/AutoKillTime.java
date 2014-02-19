/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class AutoKillTime extends CommandBase {

    public AutoKillTime() {
    }

    protected void initialize() {
        setTimeout(4);
        System.out.println("Started AutoKillTime.");
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return (isTimedOut() || RobotMap.hotGoal);
    }

    protected void end() {
    }

    protected void interrupted() {
    }

}
