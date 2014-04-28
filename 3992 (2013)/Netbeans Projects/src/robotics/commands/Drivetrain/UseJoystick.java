package robotics.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.*;
import robotics.subsystems.*;

public class UseJoystick extends Command
{
    private Drivetrain drivetrain;
    
    public UseJoystick() 
    {
        drivetrain = Drivetrain.getInstance();
        requires (drivetrain);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {}

    protected void execute() 
    {
        drivetrain.driveWithJoystick();
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
