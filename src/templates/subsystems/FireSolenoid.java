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
public class FireSolenoid extends Subsystem {

    private Relay solenoid;
    
    protected void initDefaultCommand() {
        
    }
    
    public FireSolenoid() {
        super();
        solenoid = new Relay(RobotMap.SOLENOID_PASSING_PORT);
    }
    
    public void toggle() {
        if (solenoid.get().equals(Relay.Value.kOn)) {
            solenoid.set(Relay.Value.kOff);
        }
        else {
            solenoid.set(Relay.Value.kOn);
        }
    }
}
