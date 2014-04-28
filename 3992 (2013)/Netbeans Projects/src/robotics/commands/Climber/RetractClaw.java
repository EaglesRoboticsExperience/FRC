package robotics.commands.Climber;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class RetractClaw extends Command
{
    private Climber climber;
    
    public RetractClaw()
    {
        climber = Climber.getInstance();
        requires (climber);
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() 
    {
        climber.retractClaw();
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
