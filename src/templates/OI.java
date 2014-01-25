/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

/**
 *
 * @author Developer
 */
public class OI {
    //public static Joystick leftJoystick = new Joystick(1);
    //public static Joystick rightJoystick = new Joystick(2);
    private XboxController xbox;
    
    public OI() {
        xbox = new XboxController(1); //Be careful not to plug in multiple USB Items...
    }
    
    public XboxController getXbox() {
        return xbox;
    }
}
