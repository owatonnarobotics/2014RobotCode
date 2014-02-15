/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates;

import edu.wpi.first.wpilibj.camera.AxisCamera;

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
    
    public static final int SPINNING_BALL_GRABBER_PORT = 7; // Picks up the ball *Is Jaguar #5
    
    //Relays
    public static final int SOLENOID_PASSING_PORT = 8;      // The that launches the ball to pass
    public static final int MOTOR_360 = 6;                  // Spins the motor that launches the ball
    public static final int COMPRESSOR_PORT = 5;            // Turns on (and off) compressor
    public static final int LAUNCH_SOLENOID = 1;            // Turns on the pneumatics to fling the arms up
    
    //Digital IO
    public static final int DIGITAL_SENSOR = 6;             // Detects whether 360 motor went a full 360
    public static final int COMPRESSOR_GAUGE = 5;           // Another port for the compressor
    public static final int FRONT_SENSOR = 4;               // Detects distance in front of robot
    //Ultrasonic Sensor
    public static final int PING_CHANNEL = 1;
    public static final int ECHO_CHANNEL = 2;
    
    //Buttons
    public static final int PASS = XboxController.ButtonType.kLTrigger.value;   // If you can't figure this one out...
    public static final int LAUNCH = XboxController.ButtonType.kRTrigger.value;
    
    //Shot range
    public static final double minRange = 7 * 12;
    public static final double maxRange = 16 * 12;
    
    //World Varibles
    public static boolean hotGoal = false;
    
    //Camera IP
    public final static String cameraIP = "10.46.24.11";
    
    //Camera
    public static AxisCamera camera;
}
//Magikarp is better than Ditto. Nothing is better than the Guillotine. No one likes Gyarados. Dang it, Lord Michael! Foiled again!

//Something with the launch switch is broken...
//Compressor going too high. Not our fault I think.
//Watchdog not fed again during rTrigger
