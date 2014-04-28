package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Catapult extends Subsystem 
{
    private static Catapult instance = null;
    
    private Solenoid launch1, launch2, lock;
    private DigitalInput click;
    private String lockOutput, pistonOutput;
    
    private Catapult()
    {
        launch1 = new Solenoid(1);
        launch2 = new Solenoid(2);
        lock = new Solenoid(3);
        click = new DigitalInput(2); //check to see what channel it should be plugged into, needs to return true when pressed down
        
        //initialize();
    }
    
    public void initialize()
    {
        unlock();
        extend();
        while(click.get())
        {
            
        }
        Timer.delay(1.0);
        lock();
        
        lockOutput = "Ready";
        pistonOutput = "";
        display();
    }
    
    private void display()
    {
        SmartDashboard.putString("Catapult: ", pistonOutput + " , " + lockOutput);
    }
    
    public boolean getSwitchValue()
    {
        return click.get();
    }
    
    public void lock()
    {
        lock.set(true);
        lockOutput = "locked";
        display();
    }
    
    public void unlock()
    {
        lock.set(false);
        lockOutput = "unlocked";
        display();
    }
    
    public void extend()
    {
        launch1.set(true);
        launch2.set(true);
        pistonOutput = "extended";
        display();
    }
    
    public void retract()
    {
        launch1.set(false);
        launch2.set(false);
        pistonOutput = "retracted";
        display();
    }
    
    public static Catapult getInstance()
    {
        if(instance == null)
        {
            instance = new Catapult();
        }
        return instance;
    }
    
    public void initDefaultCommand() {}
}