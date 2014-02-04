/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.OI;
import templates.RobotMap;
import templates.subsystems.Drive;
import templates.subsystems.FireSolenoid;
import templates.subsystems.Grabber;
import templates.subsystems.Motor360;
import templates.subsystems.Switch360;
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
    public static Switch360 switch360 = new Switch360();
    
    public static void init() {    
        oi = new OI();
        SmartDashboard.putData(drive);
    }
       
    public CommandBase() {
        super();
    }
   
}