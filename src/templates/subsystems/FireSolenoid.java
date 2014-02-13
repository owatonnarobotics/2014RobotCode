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

    public void toggleOff() {
        solenoid.set(Relay.Value.kOff);
    }

    public void toggleOn() {
        solenoid.set(Relay.Value.kForward);
    }
}