package robotics.commands.Intake;

import edu.wpi.first.wpilibj.command.Command;
import robotics.subsystems.IntakeMotor;

public class Reverse extends Command 
{
    private IntakeMotor intake;
    
    public Reverse() 
    {
        intake = IntakeMotor.getInstance();
        requires(intake);
    }

    protected void initialize() {}

    protected void execute() 
    {
        intake.reverse();
    }

    protected boolean isFinished() 
    {
        return false;
    }

    protected void end() 
    {
        
    }

    protected void interrupted() 
    {
        intake.stop();
    }
}