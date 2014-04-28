package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class OpenLoaderDoor extends Command 
{
    private Launcher launcher;

    
    public OpenLoaderDoor() 
    {
        
        launcher = Launcher.getInstance();
        requires (launcher);
        
    }

    protected void initialize() {
        launcher.openLoaderDoor();
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

    protected void interrupted() {}
}
