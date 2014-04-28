package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;

public class TurnLauncherOn extends Command 
{
    private Launcher launcher;
    private boolean completed;
    private double motorSpeed;
    
    public TurnLauncherOn(double speed) 
    {
        launcher = Launcher.getInstance();
        requires (launcher);
        
        completed = false;
        motorSpeed = -1 * speed; //reversed because lol
        
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() {
       System.out.println("Setting launcher speed " + motorSpeed);
       launcher.setLauncherSpeed(motorSpeed);
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
    }
}
