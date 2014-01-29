/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import templates.subsystems.TheOneMotor;

/**
 *
 * @author Developer
 */
public class OI {
    //public static Joystick leftJoystick = new Joystick(1);
    //public static Joystick rightJoystick = new Joystick(2);
    private XboxController xbox;
    private Button oneMotor;
    
    public OI() {
        xbox = new XboxController(1); //Be careful not to plug in multiple USB Items...
        
        oneMotor = new JoystickButton(xbox, RobotMap.ONE_MOTOR);
        
        oneMotor.whenPressed(new TheOneMotor());
    }
    
    public XboxController getXbox() {
        return xbox;
    }
    
    
}
