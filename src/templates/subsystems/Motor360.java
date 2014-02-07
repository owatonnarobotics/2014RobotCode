/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class Motor360 extends Subsystem {
    
    private Relay switchMotor;
    private DigitalInput motorSensor;
    
    protected void initDefaultCommand() {
    }
    
    public boolean check() {
        return motorSensor.get();
    }
    
    public void turnOn() {
        switchMotor.set(Relay.Value.kOn);
    }
    
    public void turnOff() {
        switchMotor.set(Relay.Value.kOff);
    }
    
    public void rotate() {
        boolean completed = false;
        boolean exitedSensor = false;
        while (!completed) {
            switchMotor.set(Relay.Value.kOn);
            if (motorSensor.get() && exitedSensor) {
                completed = true;
            }
            else if (!motorSensor.get()) {
                exitedSensor = true;
            }
        }
        switchMotor.set(Relay.Value.kOff);
    }
    
    public Motor360() {
        super();
        switchMotor = new Relay(RobotMap.SWITCH_MOTOR);
        motorSensor = new DigitalInput(RobotMap.DIGITAL_SENSOR);
    }
}
