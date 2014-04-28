package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class ExtendPin extends Command 
{
    private Launcher launcher;
    private boolean completed;
    
    public ExtendPin(double duration) 
    {
        super (duration);
        
        launcher = Launcher.getInstance();
        requires (launcher);
        
        completed = false;
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {}

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        if (!completed)
        {
            launcher.extendLauncherPin();
            System.out.println ("Pin extended");
        }
        
        completed = true;
    }

    protected boolean isFinished() 
    {
        return completed && isTimedOut();
    }

    protected void end() {}

    protected void interrupted() {}
}
