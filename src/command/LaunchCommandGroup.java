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
public class LaunchCommandGroup extends CommandGroup {

    public LaunchCommandGroup() {
        addSequential(new LaunchCommand());
        addSequential(new KillTime(2)); // We changed the KillTime method so hopefully this doesn't breaks
        addSequential(new EnablePneumatics());
    }
}
// duhtekt dystinss <- Pranshu's Awesome Idea for detecting distance 