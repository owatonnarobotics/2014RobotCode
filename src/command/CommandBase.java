/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.OI;
import templates.subsystems.Drive;

/**
 *
 * @author Developer
 */
public abstract class CommandBase extends Command {

    public static OI oi;
  
    public static Drive drive = new Drive();
    
    public static void init() {    
        oi = new OI();
        
        SmartDashboard.putData(drive);
    }
        
    public CommandBase() {
        super();
    }
   
}
// It's a... Christmas Miracle