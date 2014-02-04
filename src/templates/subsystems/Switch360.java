/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class Switch360 extends Subsystem {
    public static DigitalInput motorSensor;
    
    protected void initDefaultCommand() {
        
    }
    
    public boolean check() {
        return motorSensor.get();
    }
    
    public Switch360() {
        super();
        motorSensor = new DigitalInput(RobotMap.DIGITAL_SENSOR);
    }
}
