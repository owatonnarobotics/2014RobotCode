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
public class TheOneMotor extends Subsystem {
    
    //private Jaguar motorThingy = new Jaguar();
    private boolean isOn = false;
    
    public void toggle() {
        isOn = !isOn;
        if (isOn) {
            //Drive At Speed .5 ?
            //motorThingy.set(.5);
        }
        else {
            //motorThingy.set(0);
        }
    }
    
    public TheOneMotor() {
        
    }

    protected void initDefaultCommand() {
    }   
}