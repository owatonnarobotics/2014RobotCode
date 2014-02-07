/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.OI;
import templates.subsystems.Compressor;
import templates.subsystems.Drive;
import templates.subsystems.FireSolenoid;
import templates.subsystems.Grabber;
import templates.subsystems.LaunchSpike;
import templates.subsystems.LaunchSwitch;
import templates.subsystems.Motor360;
import templates.subsystems.TheOneMotor;

/**
 *
 * @author Developer
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    
    
    public static Drive drive = new Drive();
    public static TheOneMotor oneMotor = new TheOneMotor();
    public static Grabber grab = new Grabber();
    public static FireSolenoid solenoid = new FireSolenoid();
    public static Motor360 motor360 = new Motor360();
    public static Compressor compressor = new Compressor();
    public static LaunchSpike launcher = new LaunchSpike();
    //I think CheckLaunchSwitch should go here? Maybe?
    public static LaunchSwitch detector = new LaunchSwitch();
    
    public static void init() {    
        oi = new OI();
        SmartDashboard.putData(drive);
    }
       
    public CommandBase() {
        super();
    }
   
}