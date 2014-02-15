/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templates.subsystems;

import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class DistanceReader extends Subsystem{
    private Ultrasonic sensor;
    
    protected void initDefaultCommand() {
        
    }
    
    public double getDistance(){
        return sensor.getRangeInches();
    }
    
    public boolean inRange(){
        double distance = sensor.getRangeInches();
        return RobotMap.minRange < distance && distance < RobotMap.maxRange;
    }
    
    public DistanceReader(){
        sensor = new Ultrasonic(RobotMap.PING_CHANNEL, RobotMap.ECHO_CHANNEL);
        sensor.setEnabled(true);
        sensor.setAutomaticMode(true);
    }
}
