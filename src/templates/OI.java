/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import command.Motor360On;
import command.PassCommand;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 *
 * @author Developer
 */
public class OI {
    //public static Joystick leftJoystick = new Joystick(1);
    //public static Joystick rightJoystick = new Joystick(2);
    private XboxController xbox;
    private Button switchSpin;
    private Button launch;
    
    public OI() {
        xbox = new XboxController(1); //Be careful not to plug in multiple USB Items...
        
        switchSpin = new JoystickButton(xbox, RobotMap.PASS);
        launch = new JoystickButton(xbox, RobotMap.LAUNCH);
        
        switchSpin.whenPressed(new PassCommand());
        launch.whenPressed(new Motor360On());
    }
    
    public XboxController getXbox() {
        return xbox;
    }
    
    
}
