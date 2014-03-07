package templates;

import command.Autonomous;
import command.CommandBase;
import command.DriveCommand;
import command.FrontSensorToDash;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Scheduler;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to each mode, as described in the IterativeRobot documentation. If you change the name of this class or the package after creating this project, you must also update the manifest file in the resource directory.
 */
public class Robot extends IterativeRobot {

    Watchdog watchdog;
    DriveCommand mecDrive;
    FrontSensorToDash info;
    Autonomous auto;

    /**
     * This function is run when the robot is first started up and should be used for any initialization code.
     */
    public void robotInit() {
        watchdog = Watchdog.getInstance();
        watchdog.setEnabled(false);
        CommandBase.init(); //initializes commands
        mecDrive = new DriveCommand();
        info = new FrontSensorToDash();
        auto = new Autonomous();
        //RobotMap.camera = AxisCamera.getInstance();
    }

    public void autonomousInit() {
        auto.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        if (!watchdog.getEnabled()) {
            watchdog.setEnabled(true);
        }
        mecDrive.start();
        info.start();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        watchdog.feed();
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {

    }

}
