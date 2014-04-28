package robotics;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import robotics.commands.Autonomous.AutonomousCommand;

import robotics.subsystems.*;

public class Main extends IterativeRobot 
{
    boolean auto = false;
    Command autonomousCommand;
    Watchdog watchdog;

    public void robotInit() 
    {
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousCommand();

        // Initialize all subsystems
        //VisionProcessing.getInstance();
        Drivetrain.getInstance();
        OI.getInstance();
        Shifter.getInstance();
        IntakeMotor.getInstance();
        IntakePiston.getInstance();
        Catapult.getInstance();
    }

    public void autonomousInit() 
    {
        // schedule the autonomous command (example)
        Catapult.getInstance().initialize();
        autonomousCommand.start();
    }

    public void autonomousPeriodic() 
    {
        auto = true;
        Scheduler.getInstance().run();
    }

    public void teleopInit() 
    {
        watchdog = Watchdog.getInstance();
        if(auto)
        {
            autonomousCommand.cancel();
        }
        Catapult.getInstance().initialize();
    }

    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        watchdog.feed();
    }
    
    public void testPeriodic() 
    {
        LiveWindow.run();
    }
}
