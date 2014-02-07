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
public class LaunchSwitch extends Subsystem {

    private DigitalInput launchSwitch;
            
    public LaunchSwitch() {
        super();
        launchSwitch = new DigitalInput(RobotMap.LAUNCH_SWITCH);
    }

    protected void initDefaultCommand() {
    }
    
    public boolean check() {
        return launchSwitch.get();
    }
}
