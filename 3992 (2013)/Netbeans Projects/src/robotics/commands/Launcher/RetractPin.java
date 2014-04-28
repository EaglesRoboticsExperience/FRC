package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class RetractPin extends Command 
{
    private Launcher launcher;
    private boolean completed;
    
    public RetractPin(double duration) 
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
            launcher.retractLauncherPin();
            System.out.println ("Pin retracted");
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
