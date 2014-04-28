package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakePiston extends Subsystem 
{
    private static IntakePiston instance = null;

    private Solenoid extender;
    private String selection;
    
    public void initDefaultCommand() {}
    
    private IntakePiston()
    {
        extender = new Solenoid(4);
        extender.set(false);
        
        selection = "Retract";
        display();
    }
    
    private void display()
    {
        SmartDashboard.putString("Intake Piston: ", selection);
    }
    
    public static IntakePiston getInstance()
    {
        if(instance == null)
        {
            instance = new IntakePiston();
        }
        return instance;
    }
    
    public void extend()
    {
        extender.set(true);
        selection = "Extend";
        display();
    }
    
    public void retract()
    {
        extender.set(false);
        selection = "Retract";
        display();
    }
}