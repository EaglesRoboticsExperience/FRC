package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.command.*;
import robotics.subsystems.*;

public class AimHigher extends Command 
{
    private Launcher launcher;
    private boolean completed;
    
    public AimHigher(double duration) 
    {
        super (duration);
        
        launcher = Launcher.getInstance();
        requires (launcher);
        
        completed = false;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
        launcher.moveAngleUp();    
    }

    protected void execute() 
    {
        // this will called repeatedly but relay will be turned on in initialize
    }

    protected boolean isFinished() 
    {
        return false;
        //return isTimedOut();
    }

    protected void end() 
    {
        // nothing to do     
    }

    protected void interrupted() {
        launcher.stopAdjustment();
    }
}
