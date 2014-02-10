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
        //We would make commands such as
        //addSequential(new Flamethrower());
        //
        //to run two at once, use
        //addParallel(new Flamethrower()); then
        //addSequential(new Flamethrower());
        //
        //That's all we need in here!
        
        addSequential(new DetectHotGoal());
        addSequential(new AutonomousDrive());
        addSequential(new LaunchCommand());
    }
    
}