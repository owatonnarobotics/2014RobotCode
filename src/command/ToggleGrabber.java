/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.subsystems.Grabber;
import templates.subsystems.LaunchSpike;

/**
 *
 * @author Developer
 */
public class ToggleGrabber extends CommandBase{
    
    public ToggleGrabber(){
        requires(grab);
    }
    
    protected void initialize() {
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
        grab.toggleOn();
        SmartDashboard.putBoolean("Pull On", Grabber.motorOn);
    }

    protected void interrupted() {

    }
    
}
