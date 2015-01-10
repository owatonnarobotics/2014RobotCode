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
public class EnablePneumatics extends CommandBase {

    public EnablePneumatics() {
        requires(launcher);
    }

    protected void initialize() {

    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return (true);
    }

    protected void end() {
        launcher.toggleOn();
    }

    protected void interrupted() {

    }

}
