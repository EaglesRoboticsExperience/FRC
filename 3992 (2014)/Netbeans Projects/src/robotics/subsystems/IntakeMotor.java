package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeMotor extends Subsystem 
{
    private static IntakeMotor instance = null;
    
    private SpeedController intaker;
    private String selection;
    
    private IntakeMotor()
    {
        intaker = new Victor(7);            //make sure to change to this during competition
        //intaker = new Jaguar(2);
    }
    
    public void initDefaultCommand() {}
    
    private void display()
    {
        SmartDashboard.putString("Intake Motor: ", selection);
    }
    
    public static IntakeMotor getInstance()
    {
        if(instance == null)
        {
            instance = new IntakeMotor();
        }
        return instance;
    }
    
    public void reverse()
    {
        intaker.set(1.0);
        selection = "Reverse";
        display();
    }
    
    public void forward()
    {
        intaker.set(-1.0);
        selection = "Forward";
        display();
    }
    
    public void stop()
    {
        intaker.set(0.0);
        selection = "Stopped";
        display();
    }
    
}