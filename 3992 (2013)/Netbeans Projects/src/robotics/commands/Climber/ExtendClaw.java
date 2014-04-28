package robotics.commands.Climber;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class ExtendClaw extends Command
{
    private Climber climber;
    
    public ExtendClaw()
    {
        climber = Climber.getInstance();
        requires (climber);
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() 
    {
        climber.extendClaw();
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
