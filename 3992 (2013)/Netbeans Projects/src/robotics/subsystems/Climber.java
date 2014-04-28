package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import robotics.commands.Climber.*;

public class Climber extends Subsystem 
{
    private static Climber instance = null;
    
    private Solenoid lowClimbGrabber;
    
    private Climber()
    {
        lowClimbGrabber = new Solenoid (2);
    }
    
    public static Climber getInstance()
    {
        if (instance == null)
        {
            instance = new Climber();
        }
        
        return instance;
    }
    
    public void initDefaultCommand() 
    {
        
    }
    
    public void extendClaw()
    {
        lowClimbGrabber.set (true);
    }
    
    public void retractClaw()
    {
        lowClimbGrabber.set (false);
    }
}
