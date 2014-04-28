package robotics.commands.Intake;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import robotics.subsystems.IntakePiston;

public class ExtendIntake extends Command 
{
    private IntakePiston intake;
    private String gameMode;
    
    public ExtendIntake() 
    {
        intake = IntakePiston.getInstance();
        requires(intake);
        gameMode = "Teleop";
    }
    
    public ExtendIntake(double timeOut)
    {
        intake = IntakePiston.getInstance();
        requires(intake);
        setTimeout(timeOut);
        gameMode = "Auto";
    }

    protected void initialize() {}

    protected void execute() 
    {
        intake.extend();
    }

    protected boolean isFinished() 
    {
        if(gameMode.equals("Teleop"))
        {
            return false;
        }
        else
        {
            return isTimedOut();
        }
    }

    protected void end() 
    {
        if(gameMode.equals("Auto"))
        {
            intake.retract();
        }
    }

    protected void interrupted() 
    {
        intake.retract();
    }
}