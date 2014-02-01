/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package templates.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.RobotMap;

/**
 *
 * @author Rebel Scum
 */
public class Grabber extends Subsystem {
    private Jaguar jGrab;

    protected void initDefaultCommand() {
    }
    
    //this switches the direction of the grabber
    public void switchSpin() {
        jGrab.set(jGrab.get() * -1);
        
    }
    
    public Grabber() {
        super();
        jGrab = new Jaguar(RobotMap.SPINNING_BALL_GRABBER_PORT);
        jGrab.set(-.5);
    }
}
