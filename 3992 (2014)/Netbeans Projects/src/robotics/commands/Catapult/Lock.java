package robotics.commands.Catapult;

import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.*;

public class Lock extends Command 
{
    private Catapult catapult;
    
    public Lock() 
    {
        catapult = Catapult.getInstance();
        requires(catapult);
    }

    protected void initialize() {}

    protected void execute() 
    {
        catapult.unlock();
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() {}

    protected void interrupted() 
    {
        catapult.lock();
    }
}
