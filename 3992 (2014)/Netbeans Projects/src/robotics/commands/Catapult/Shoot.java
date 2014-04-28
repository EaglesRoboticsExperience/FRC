package robotics.commands.Catapult;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

import robotics.subsystems.*;

public class Shoot extends Command
{
    private Catapult launcher;
    private IntakePiston intake;
    private String gameMode;
    private double wait;
    
    public Shoot() 
    {
        launcher = Catapult.getInstance();
        intake = IntakePiston.getInstance();
        requires(intake);
        requires(launcher);
        gameMode = "Teleop";
    }
    
    public Shoot(double wait)
    {
        launcher = Catapult.getInstance();
        intake = IntakePiston.getInstance();
        requires(intake);
        requires(launcher);
        gameMode = "Auto";
        this.wait = wait;
    }

    protected void initialize() 
    {
        if(gameMode.equals("Auto"))
        {
            intake.extend();
            Timer.delay(wait);
        }
        else
        {
            intake.extend();
            Timer.delay(0.75);
        }
        launcher.unlock();
    }

    protected void execute()
    {
        Timer.delay(1.0);
    }

    protected boolean isFinished() 
    {
        return true;
    }

    protected void end() 
    {
        if(gameMode.equals("Auto"))
        {
           intake.retract();
        }
        else
        {
            intake.retract();
            launcher.extend();
            while(launcher.getSwitchValue())
            {
                
            }
            Timer.delay(0.25);
            launcher.lock();
        }
    }
    
    protected void interrupted() {}
}