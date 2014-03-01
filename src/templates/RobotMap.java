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

    //Jaguars [PWMs]
    public static final int MECANUM_BACK_LEFT = 1;
    public static final int MECANUM_BACK_RIGHT = 2;
    public static final int MECANUM_FRONT_LEFT = 3;
    public static final int MECANUM_FRONT_RIGHT = 4;
    
    public static final int SPINNING_BALL_GRABBER_PORT = 7; // {Ball Acquisition Motor} *Is Jaguar #5
    
    //Relays
    public static final int SOLENOID_PASSING_PORT = 8;      // The that launches the ball to pass
    public static final int MOTOR_360 = 6;                  // {Shooter Window Motor} Spins the motor that launches the ball (Window Motor)
    public static final int COMPRESSOR_PORT = 4;            // Turns on (and off) compressor
    public static final int LAUNCH_SOLENOID = 1;            // {Pnuematic Solenoid} Turns on the pneumatics to fill the arms to fling the arms up
    
    //Digital IO
    public static final int DIGITAL_SENSOR = 6;             // {Window Motor Position} Detects whether 360 motor went a full 360
    public static final int COMPRESSOR_GAUGE = 5;           // {Pressure Sensor} Another port for the compressor
        //Ultrasonic Sensors
    public static final int PING_CHANNEL = 2;               // [Not Used]
    public static final int ECHO_CHANNEL = 1;               // {UltraRange Finder} The echo channel for the ultrasonic rangefinder
    
    //Buttons
    public static final int PASS = XboxController.ButtonType.kLTrigger.value;   // If you can't figure this one out...
    public static final int LAUNCH = XboxController.ButtonType.kRTrigger.value;
    public static final int PASS_TOGGLE = XboxController.ButtonType.kR.value;   // The button that switches the grabber on and off
    
    //Shot Range
    public static final double minRange = 7 * 12;
    public static final double maxRange = 15.5 * 12;
    
        //Autonomous Shot Range
    public static final double minAutoRange = 7 * 12;
    public static final double maxAutoRange = 13 * 12;
    
    //World Varibles
    public static boolean hotGoal = false;
    
    //Camera IP
    public final static String cameraIP = "10.46.24.11";
    
    //Camera
    public static AxisCamera camera;
}
