package robotics.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.tables.TableKeyNotDefinedException;
import edu.wpi.first.wpilibj.smartdashboard.*;

import robotics.*;
import robotics.commands.Launcher.*;

public class Launcher extends Subsystem 
{
    private SpeedController launcherBack; //first motor for frisbee to pass through
    private SpeedController launcherFront; //second motor for frisbee to pass through
    
    private Solenoid launcherPin;
    private Solenoid loader;
    
    private Relay angleRight, angleLeft;
    
    private static Launcher instance = null;
    
    private NetworkTable table;
    private AnalogChannel potentiometer;
    
    private Launcher()
    {
        launcherBack = new Jaguar (5);
        launcherFront = new Jaguar (6);
        
        launcherPin = new Solenoid (1);
        loader = new Solenoid (3);
        angleRight = new Relay (2);
        angleLeft = new Relay (3);
        
        table = NetworkTable.getTable("SmartDashboard");
        potentiometer = new AnalogChannel (1);
    }
    
    public static Launcher getInstance()
    {
        if (instance == null)
        {
            instance = new Launcher();
            //default command set in OperatorInterface class;
        }
        
        return instance;
    }
    
    public void initDefaultCommand() 
    {
        
    }
    
    public void setLauncherSpeed(double speed)
    {
        launcherBack.set (speed);
        launcherFront.set (speed);
    }
    
    public void retractLauncherPin()
    {
        launcherPin.set (false);
    }
    
    public void extendLauncherPin()
    {
        launcherPin.set (true);
    }
    
    public void openLoaderDoor() {
        loader.set(true);
    }
    
    public void closeLoaderDoor() {
        loader.set(false);
    }
    
    public void moveAngleDown()
    {
        angleRight.set (Relay.Value.kReverse);
        angleLeft.set (Relay.Value.kReverse);
    }
    
    public void moveAngleUp()
    {
        angleRight.set (Relay.Value.kForward);
        angleLeft.set (Relay.Value.kForward);
    }
    
    public void moveRightUp() {
    }
    
    public void stopAdjustment()
    {
        angleRight.set (Relay.Value.kOff);
        angleLeft.set (Relay.Value.kOff);
    }
    
    public double getSensorVoltage()
    {
       double voltage = potentiometer.getVoltage();
        
       return potentiometer.getVoltage();
    }
    
    public double getDistance()
    {
        double distance = -1.0;
        
        try
        {
            //distance = table.getNumber ("Distance");
        }
        catch (TableKeyNotDefinedException e) 
        {
            //System.out.println ("Distance could not be retrieved");
        };
        
        return distance;
    }
    
    public void setDefault (SmartDashboard smartDashboard)
    {
        instance.setDefaultCommand (new SuggestAngle(smartDashboard, 1.0));
    }
}
