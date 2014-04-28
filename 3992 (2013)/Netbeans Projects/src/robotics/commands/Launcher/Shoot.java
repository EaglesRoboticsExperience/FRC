package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.command.*;
import robotics.subsystems.*;

public class Shoot extends Command 
{
    private Launcher launcher;
    private boolean completed;
    
    public Shoot() 
    {
        super ();
        
        launcher = Launcher.getInstance();
        requires (launcher);
        
        completed = false;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
        launcher.extendLauncherPin();  
    }

    protected void execute() 
    {
        // this will be called repeatedly but relay is was already turned on in initialize()
    }

    protected boolean isFinished() 
    {
        return false;
        //return isTimedOut();
    }

    protected void end() 
    {
    }

    protected void interrupted() {
        launcher.retractLauncherPin();
    }
}
