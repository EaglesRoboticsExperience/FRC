package robotics.commands.Catapult;

import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.Catapult;

public class RetractPistons extends Command
{    
    private Catapult launcher;
    
    public RetractPistons() 
    {
        launcher = Catapult.getInstance();
        requires(launcher);
    }

    protected void initialize() 
    {
        launcher.retract();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }
    
    protected void end() {}

    protected void interrupted() {}
}
