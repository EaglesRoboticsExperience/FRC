package robotics.commands.Shifter;

import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.Shifter;
        
public class ShiftTorque extends Command 
{
    private Shifter shifter;
    
    public ShiftTorque() 
    {
        shifter = Shifter.getInstance();
        requires(shifter);
    }

    protected void initialize() 
    {
        shifter.shiftTorque();
    }

    protected void execute() {}

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() {}

    protected void interrupted() {}
}
