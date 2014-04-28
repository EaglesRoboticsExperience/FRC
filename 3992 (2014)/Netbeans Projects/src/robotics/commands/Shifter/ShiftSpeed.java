package robotics.commands.Shifter;

import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.Shifter;

public class ShiftSpeed extends Command 
{
    private Shifter shifter;
    
    public ShiftSpeed() 
    {
        shifter = Shifter.getInstance();
        requires(shifter);
    }

    protected void initialize() 
    {
        shifter.shiftSpeed();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
