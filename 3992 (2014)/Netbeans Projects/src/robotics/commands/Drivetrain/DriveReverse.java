package robotics.commands.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.*;

public class DriveReverse extends Command 
{
    private Drivetrain drive;
    
    public DriveReverse(double wait) 
    {
        drive = Drivetrain.getInstance();
        requires(drive);
        setTimeout(wait);
    }

    protected void initialize() {}

    protected void execute() 
    {
        drive.reverse();
    }

    protected boolean isFinished() 
    {
        return isTimedOut();
        //return drive.inRange();
    }

    protected void end() 
    {
        drive.stop();
    }

    protected void interrupted() {}
}