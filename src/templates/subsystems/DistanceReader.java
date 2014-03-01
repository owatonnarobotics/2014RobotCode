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
    private int trueAutoCount = 0; // The number of times the range was correct
    
    protected void initDefaultCommand() {
        
    }
    
    public double getDistance(){
        double distance = sensor.getRangeInches();
        System.out.println(distance);
        return distance;
    }
    
    public boolean inRange(){
        double distance = this.getDistance();
        return RobotMap.minRange < distance && distance < RobotMap.maxRange;
    }
    
    public boolean inAutoRange(){
        double distance = this.getDistance();
        boolean inRange = RobotMap.minAutoRange < distance && distance < RobotMap.maxAutoRange;
        if(inRange){
            trueAutoCount += 1;
        }
        else{
            trueAutoCount = 0;
        }
        return trueAutoCount > 5;
    }
    
    public DistanceReader(){
        sensor = new Ultrasonic(RobotMap.PING_CHANNEL, RobotMap.ECHO_CHANNEL);
        sensor.setEnabled(true);
        sensor.setAutomaticMode(true);
    }
}
