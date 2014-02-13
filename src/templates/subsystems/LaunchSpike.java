/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templates.subsystems;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class LaunchSpike extends Subsystem {
    
   private Relay launcher; //lawn chair

    protected void initDefaultCommand() {
        }
    
    public LaunchSpike() {
        super();
        launcher = new Relay(RobotMap.LAUNCH_SOLENOID);
        launcher.set(Relay.Value.kForward);
    }
    
    public void toggleOn() {
        launcher.set(Relay.Value.kForward);
    }
    
    public void toggleOff() {
        launcher.set(Relay.Value.kOff);
    }
}
