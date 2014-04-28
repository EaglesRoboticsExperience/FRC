package robotics;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Watchdog;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

import robotics.subsystems.*;
import robotics.commands.Launcher.*;

public class Main extends IterativeRobot 
{
    Command autonomousCommand;
    SendableChooser autoChooser;
    
    Watchdog watchdog;
    OperatorInterface oi;
    
    //called when robot is first enabled
    public void robotInit() 
    {
        Drivetrain.getInstance();
        oi = OperatorInterface.getInstance();
        Launcher.getInstance();
        Climber.getInstance();
        
        autoChooser = new SendableChooser();
        autoChooser.addObject ("Back Left", new AutonomousThreePointer (AutonomousThreePointer.LEFT_BACK));
        autoChooser.addDefault ("Back Center", new AutonomousThreePointer (AutonomousThreePointer.CENTER_BACK));
        autoChooser.addObject ("Back Right", new AutonomousThreePointer (AutonomousThreePointer.RIGHT_BACK));
        autoChooser.addObject ("Front Left", new AutonomousThreePointer (AutonomousThreePointer.LEFT_FRONT));
        autoChooser.addObject ("Front Center", new AutonomousThreePointer (AutonomousThreePointer.CENTER_FRONT));
        autoChooser.addObject ("Front Right", new AutonomousThreePointer (AutonomousThreePointer.RIGHT_FRONT));
        
        oi.getSmartDashboard().putData ("Autonomous Program Chooser", autoChooser);
    }
    
    public void autonomousInit()
    {
        autonomousCommand = (Command) autoChooser.getSelected();
        autonomousCommand.start();
    }
    
    public void autonomousPeriodic()
    {
        Scheduler.getInstance().run();
    }
    
    //called once at start of teleop period
    public void teleopInit()
    {
        watchdog = Watchdog.getInstance();
        
        if (autonomousCommand != null)
            autonomousCommand.cancel();
    }
    
    //called over and over during teleop period
    public void teleopPeriodic() 
    {
        Scheduler.getInstance().run();
        SmartDashboard.putData ("Scheduler Data: ", Scheduler.getInstance());
        
        watchdog.feed();
    }
}
