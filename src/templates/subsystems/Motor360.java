/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class Motor360 extends Subsystem {
    private Jaguar switchMotor;
    private boolean isFinished = false;

    protected void initDefaultCommand() { 
    }
    
    public void turnOn() {
        switchMotor.set(.5);
    }
    
    public void turnOff() {
        switchMotor.set(0);
    }
    
    public Motor360() {
        super();
        switchMotor = new Jaguar(RobotMap.SWITCH_MOTOR);
    }
}
