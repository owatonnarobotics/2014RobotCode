/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;

import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class FrontSensor extends Subsystem {

    private AnalogChannel frontSensor;
    private static final double CM_PER_INCH = 2.54;
    private static final double MIN_FEET = (CM_PER_INCH * 12 * 4);
    private static final double MAX_FEET = (CM_PER_INCH * 12 * 6);
    private static final double OPTIMAL_FEET = (CM_PER_INCH * 12 * 5.2);

    public FrontSensor() {
        super();
        frontSensor = new AnalogChannel(RobotMap.FRONT_SENSOR);
    }

    public boolean inShootingRange() {
        int currentValue = frontSensor.getValue();
        return (currentValue > MIN_FEET && currentValue < MAX_FEET);
    }
    
    public boolean inOptimalRange() {
        return (frontSensor.getValue() < OPTIMAL_FEET);
    }

    protected void initDefaultCommand() {
    }
}
