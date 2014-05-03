/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import templates.OI;
import templates.RobotMap;
import templates.XboxController;

    

/**
 *
 * @author execute() {Lord Michael Guillotine I} &     Preston.doDatThang(start) &     import package export private protected static abstract void implements public synchronized int extends super double Evan &     drunkEEEEETHTHTNAAAHAHSNDFNNNN.operateHeavyMachinery &    Jason Bourne(Stephen)
 */
public class Drive extends Subsystem {
    private Jaguar jFL;
    private Jaguar jBL;
    private Jaguar jFR;
    private Jaguar jBR;   
    private RobotDrive drive;
    
    private double speed;
    
    private final double autoSpeed = 0.31;

    public Drive() {
        super();
        jFL = new Jaguar(RobotMap.TANK_FRONT_LEFT);
        jBL = new Jaguar(RobotMap.TANK_BACK_LEFT);
        jFR = new Jaguar(RobotMap.TANK_FRONT_RIGHT);
        jBR = new Jaguar(RobotMap.TANK_BACK_RIGHT);
        drive = new RobotDrive(jFL, jBL, jFR, jBR);
    }
    
    protected void initDefaultCommand() {
    }
      
    public void execute(XboxController controller) {
        //double xleft = controller.getX(GenericHID.Hand.kLeft);
        double yleft = controller.getY(GenericHID.Hand.kLeft);
        //double xright = controller.getX(GenericHID.Hand.kRight);
        double yright = controller.getY(GenericHID.Hand.kRight);
        
        drive.tankDrive(joystickSensitivity(yleft), joystickSensitivity(yright));
    }
    
    public void forward(){
//        double speed = jFL.get();
//        if(speed > autoSpeed * -1){
//            speed -= 0.01;
//        }
        drive.tankDrive(autoSpeed, autoSpeed);
    }
    
    public void left(){
        drive.tankDrive(0, autoSpeed);
    }
    
    public void right(){
        drive.tankDrive(autoSpeed, 0);
    }
    
    public void stop(){
        drive.tankDrive(0, 0);
    }

    private static double joystickSensitivity(double num){ // joySense Ooh La La
        double a = 0.8;
        return (a * (num * num * num) + (1 - a) * num);
    }
}
        
    
    
    

