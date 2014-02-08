/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

/**
 *
 * @author Developer
 */
public class RobotMap {

    //Jaguars
    public static final int MECANUM_BACK_LEFT = 1;
    public static final int MECANUM_BACK_RIGHT = 2;
    public static final int MECANUM_FRONT_LEFT = 3;
    public static final int MECANUM_FRONT_RIGHT = 4;
    
    public static final int SPINNING_BALL_GRABBER_PORT = 9; //port for that spinning thing that grabs the ball
    
    //Relays
    public static final int SOLENOID_PASSING_PORT = 7; //port for the solenoid thing in passcommand
    public static final int SWITCH_MOTOR = 6;
    public static final int COMPRESSOR_PORT = 5;
    public static final int LAUNCH_MOTOR = 8;
    
    //Digital IO
    public static final int DIGITAL_SENSOR = 6;
    public static final int COMPRESSOR_GAUGE = 5;
    public static final int LAUNCH_SWITCH = 3; //Technic Launcher, Dingbat!

    //Buttons
    public static final int PASS = XboxController.ButtonType.kLTrigger.value;
    public static final int LAUNCH = XboxController.ButtonType.kRTrigger.value;
    
    //World Varibles
    public static boolean hotGoal = false;
}
//Magikarp is better than Ditto. Nothing is better than the Guillotine. No one likes Gyrados.
