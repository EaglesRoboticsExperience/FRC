package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class TurnLauncherOff extends Command 
{
    private Launcher launcher;
    private boolean completed;
    
    public TurnLauncherOff() 
    {
        
        launcher = Launcher.getInstance();
        requires (launcher);
        
        completed = false;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
      launcher.setLauncherSpeed (0.00);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {

    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() 
    {
        completed = true;
    }
}
