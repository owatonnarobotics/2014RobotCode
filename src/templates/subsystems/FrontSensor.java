/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;

import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class FrontSensor extends Subsystem {

    private PWM frontSensor;

    public FrontSensor() {
        super();
        frontSensor = new PWM(RobotMap.FRONT_SENSOR);
    }

    public boolean inShootingRange() {
        if (frontSensor.getRaw() > 4 && frontSensor.getRaw() < 6) {
            return true;
        }
        return false;
    }
    
    public boolean inOptimalRange() {
        if (frontSensor.getRaw() < 5.2) {
            return true;
        }
        return false;
    }

    protected void initDefaultCommand() {
    }
}
