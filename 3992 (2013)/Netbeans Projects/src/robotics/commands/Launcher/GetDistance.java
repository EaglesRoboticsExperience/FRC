package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.*;
import robotics.subsystems.*;

public class GetDistance extends Command 
{
    private Launcher launcher;
    private double distance;
    
    public GetDistance()
    {
        launcher = Launcher.getInstance();
        requires (launcher);
        
        distance = 0;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        distance = launcher.getDistance(); //in feet
        
        //add calculations in here?
    }

    protected boolean isFinished() 
    {
        return (distance > 0);
    }

    protected void end()
    {
        
    }

    protected void interrupted() {}
}
