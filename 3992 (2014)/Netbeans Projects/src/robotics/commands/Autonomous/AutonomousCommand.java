package robotics.commands.Autonomous;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.*;

import robotics.commands.Catapult.*;
import robotics.commands.Drivetrain.*;
import robotics.commands.Intake.*;
import robotics.commands.Shifter.ShiftTorque;
import robotics.subsystems.*;

public class AutonomousCommand extends CommandGroup 
{
    public AutonomousCommand() 
    {
        //addSequential(new ExtendIntake(0.5));
        //addSequential(new ShiftTorque());
        addSequential(new DriveReverse(0.1));
        Timer.delay(4.0);
        //Timer.delay(0.5);
        addSequential(new RetractPistons());
        //addSequential(new HotOrNot());
        Timer.delay(1.0);
        addSequential(new Shoot(2.5));
        addSequential(new DriveReverse(1.0));
    }
}