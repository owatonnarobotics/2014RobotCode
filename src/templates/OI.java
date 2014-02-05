/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import command.MotorCommandThinger;
import command.Motor360On;
import command.PassCommand;
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
    private Button switchSpin;
    private Button enable360;
    
    public OI() {
        xbox = new XboxController(1); //Be careful not to plug in multiple USB Items...
        
        oneMotor = new JoystickButton(xbox, RobotMap.ONE_MOTOR);
        switchSpin = new JoystickButton(xbox, RobotMap.SPINNING_BALL_GRABBER_PORT);
        enable360 = new JoystickButton(xbox, RobotMap.ENABLE_360);
        
        oneMotor.whenPressed(new MotorCommandThinger());
        switchSpin.whenPressed(new PassCommand());
        enable360.whenPressed(new Motor360On());
    }
    
    public XboxController getXbox() {
        return xbox;
    }
    
    
}
