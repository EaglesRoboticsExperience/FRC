package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Shifter extends Subsystem 
{
    private static Shifter instance = null;
    
    private Solenoid piston;
    private boolean mode = false;
    
    private Shifter()
    {
        piston = new Solenoid(5);
        piston.set(mode);
        display();
    }
    
    public static Shifter getInstance()
    {
        if(instance == null)
        {
            instance = new Shifter();
        }
        return instance;
    }
    
    private void display()
    {
        String value = "";
        if(!mode)
        {
            value = "Speed";
        }
        else
        {
            value = "Torque";
        }
        SmartDashboard.putString("Geared Toward ", value);
    }
    
    public void shiftSpeed()
    {
        mode = false;
        piston.set(mode);
        display();
    }
    
    public void shiftTorque()
    {
        mode = true;
        piston.set(mode);
        display();
    }
    
    public void initDefaultCommand() {}
}
