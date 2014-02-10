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
    
    public static final int SPINNING_BALL_GRABBER_PORT = 9; //picks up the ball
    
    //Relays
    public static final int SOLENOID_PASSING_PORT = 7; //the thingy that launches to pass
    public static final int MOTOR_360 = 6;  //spins the motor that launches the ball
    public static final int COMPRESSOR_PORT = 5; //turns on (and off) compressor
    public static final int LAUNCH_MOTOR = 8; //turns on the pneumatics to fling the arms up
    
    //Digital IO
    public static final int DIGITAL_SENSOR = 6; // Detects whether 360 motor went a full 360
    public static final int COMPRESSOR_GAUGE = 5; // Another port for the compressor
    public static final int LAUNCH_SWITCH = 3; //Technic Launcher, Dingbat!
    public static final int FRONT_SENSOR = 4; // Detects distance in front of robot
    

    //Buttons
    public static final int PASS = XboxController.ButtonType.kLTrigger.value; //If you can't figure this one out...
    public static final int LAUNCH = XboxController.ButtonType.kRTrigger.value;
    
    //World Varibles
    public static boolean hotGoal = false;
}
//Magikarp is better than Ditto. Nothing is better than the Guillotine. No one likes Gyarados.