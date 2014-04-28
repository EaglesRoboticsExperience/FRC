package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

import robotics.commands.Loader.*;

public class Loader extends Subsystem 
{
    private static Loader instance = null;
    
    private Solenoid extender;
    
    private Loader()
    {
    //    extender = new Solenoid (2);
    }
    
    public static Loader getInstance()
    {
        if (instance == null)
        {
            instance = new Loader();
        }
        
        return instance;
    }
    
    public void initDefaultCommand() 
    {
        
    }
    
    public void extendOutward()
    {
     //   extender.set (true);
    }
    
    public void retractInward()
    {
     //   extender.set (false);
    }
}
