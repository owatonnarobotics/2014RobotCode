/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package command;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author Developer
 */
public class Autonomous extends CommandGroup {

    public Autonomous() {
        
        addSequential(new AutonomousDrive());
        //addSequential(new DetectHotGoal());
        addSequential(new AutoKillTime());
        addSequential(new LaunchCommandGroup());
    }
    
}