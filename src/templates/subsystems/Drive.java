/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package templates.subsystems;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import templates.OI;
import templates.RobotMap;
import templates.XboxController;

    

/**
 *
 * @author execute() {Lord Michael Guillotine I} &   Preston.doDatThang(start) &   import package export private protected static abstract void implements public synchronized int extends super double Evan &   drunkEEEEETHTHTNAAAHAHSNDFNNNN.operateHeavyMachinery &  Jason Bourne(Stephen)
 */
public class Drive extends Subsystem {
    private Jaguar jFL;
    private Jaguar jBL;
    private Jaguar jFR;
    private Jaguar jBR;   
    private RobotDrive drive;
    
    private final double autoSpeed = 0.8;

    public Drive() {
        super();
        jFL = new Jaguar(RobotMap.MECANUM_FRONT_LEFT);
        jBL = new Jaguar(RobotMap.MECANUM_BACK_LEFT);
        jFR = new Jaguar(RobotMap.MECANUM_FRONT_RIGHT);
        jBR = new Jaguar(RobotMap.MECANUM_BACK_RIGHT);
        drive = new RobotDrive(jFL, jBL, jFR, jBR);
    }
    
    protected void initDefaultCommand() {
    }
    
    public void execute(XboxController controller) {
        double xleft = controller.getX(GenericHID.Hand.kLeft);
        double yleft = controller.getY(GenericHID.Hand.kLeft);
        double xright = controller.getX(GenericHID.Hand.kRight);
        
        drive.mecanumDrive_Cartesian(joystickSensitivity(xleft), joystickSensitivity(yleft), joystickSensitivity(xright),0);
        SmartDashboard.putNumber("Left  X Speed: ", joystickSensitivity(xleft)); //LaFt X SPeEd: 
        SmartDashboard.putNumber("Left  Y Speed: ", joystickSensitivity(yleft)); //LEFT Y spade: 
        SmartDashboard.putNumber("Right X Speed: ", joystickSensitivity(xright)); //Right XD speeeeed: 
    }
    
    public void forward(){
        drive.mecanumDrive_Cartesian(0, autoSpeed, 0, 0);
    }
    
    public void left(){
        drive.mecanumDrive_Cartesian(-1 * autoSpeed, 0, 0, 0);
    }
    
    public void right(){
        drive.mecanumDrive_Cartesian(autoSpeed, 0, 0, 0);
    }
    
    public void stop(){
        drive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }

    private static double joystickSensitivity(double num){ // joySense Ooh La La
        double a = 0.8;
        return (a * (num * num * num) + (1 - a) * num);
    }
}
        
    
    
    

