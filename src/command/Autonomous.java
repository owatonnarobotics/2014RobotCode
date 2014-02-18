/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;

import edu.wpi.first.wpilibj.command.CommandGroup;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
        
        addSequential(new DetectHotGoal());
        //addSequential(new AutonomousDrive());
        if(! RobotMap.hotGoal){
            //addSequential(new KillTime(4));
        }
        // Detect hot goal again?
        //addSequential(new LaunchCommand());
    }
    
}