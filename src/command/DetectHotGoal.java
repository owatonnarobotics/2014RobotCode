/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package command;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.RobotMap;

/**
 *
 * @author Developer
 */
public class DetectHotGoal extends CommandBase {
    
    public DetectHotGoal(){
        requires(camera);
    }
    
    protected void initialize() {
        RobotMap.hotGoal = false;
        System.out.println("Started Auto.");
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return true;

    }

    protected void end() {
        camera.getPic();
        System.out.println("Got picture");
        camera.processPic();
        System.out.println("Processed picture");
        if(RobotMap.hotGoal){
            System.out.println("HOT GOAL!!!!!!!");
            System.out.println("Distance: " + camera.getDistance());
        }
        else{
            System.out.println("NOT HOT GOAL");
        }
        SmartDashboard.putBoolean("IsHot", RobotMap.hotGoal);
    }

    protected void interrupted() {

    }
}
