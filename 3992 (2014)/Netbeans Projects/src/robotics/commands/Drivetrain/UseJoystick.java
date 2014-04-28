package robotics.commands.Drivetrain;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.Drivetrain;

public class UseJoystick extends Command 
{
    private Drivetrain drive;
    
    public UseJoystick() 
    {
        drive = Drivetrain.getInstance();
        requires(drive);
    }
    
    protected void initialize() {}

    protected void execute() 
    {
        drive.driveWithJoystick();
    }
    
    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {}
    
    protected void interrupted() {}
}
