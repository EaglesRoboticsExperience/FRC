package robotics.commands.Loader;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class ExtendLoader extends Command 
{
    private Loader loader;
    
    public ExtendLoader() 
    {
        loader = Loader.getInstance();
        requires (loader);
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() 
    {
        loader.extendOutward();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {}

    protected void interrupted() {}
}
