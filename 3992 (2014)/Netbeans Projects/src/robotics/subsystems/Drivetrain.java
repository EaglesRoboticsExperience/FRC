package robotics.subsystems;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import robotics.*;
import robotics.commands.Drivetrain.*;

public class Drivetrain extends Subsystem 
{
    private static Drivetrain instance = null;
    
    private SpeedController frontRight, frontLeft, backRight, backLeft;
    private Joystick joy;
    private AnalogChannel ultrasonic;
    private int minDistance, maxDistance;
    
    private Drivetrain()
    {
        
        frontLeft = new Victor(3); 
        frontRight = new Victor(6);           //MAKE SURE TO CHANGE BACK FOR COMPETITION!!!!!!!!!!!!!!!!!!!!!
        backLeft = new Victor(4);  
        backRight = new Victor(5);
        
        
        //frontLeft = new Jaguar(4); 
        //frontRight = new Jaguar(6);
        //backLeft = new Jaguar(5);  
        //backRight = new Jaguar(3);
        
        ultrasonic = new AnalogChannel(1);
        minDistance = 8;
        maxDistance = 16;
    }
    
    public void initDefaultCommand() {}
    
    public static Drivetrain getInstance()
    {
        if (instance == null)
        {
            instance = new Drivetrain();
            instance.setDefaultCommand(new UseJoystick());
        }
        return instance;
    }
    
    public void driveWithJoystick()
    {
        joy = OI.getInstance().getJoystick();
        
        double y = -1*joy.getRawAxis(2);
        double x = joy.getRawAxis(3);
            
        if(Math.abs(x) < 0.1)
        {
             x = 0;
        }
        if(Math.abs(y) < 0.1)
        {
            y = 0;
        }
        x /= 2;
        
        double leftSpeed = 0; 
        double rightSpeed = 0;
    
        rightSpeed = y - x * 2;
        leftSpeed = y + x * 2;
       
        //SmartDashboard.putNumber("X: ", x);
        //SmartDashboard.putNumber("Y: ", y);
        SmartDashboard.putNumber("Right Speed: ", rightSpeed);
        SmartDashboard.putNumber("Left Speed: ", leftSpeed);
        SmartDashboard.putNumber("Distance: ", getFeet());
        
        if(inRange())
        {
            SmartDashboard.putString("" ,"In Range");
        }
        else
        {
            SmartDashboard.putString("", "Out of Range");
        }
        
        frontRight.set(-1*rightSpeed);
        backRight.set(-1*rightSpeed);
        frontLeft.set(leftSpeed);
        backLeft.set(leftSpeed);
    }
    
    public double getFeet()
    {
        return (ultrasonic.getVoltage()/0.0098)/12.0;
    }
    
    public void forward()
    {
        frontRight.set(-0.75);
        backRight.set(-0.75);
        frontLeft.set(0.75);
        backLeft.set(0.75);
    }
    
    public void reverse()
    {
        frontRight.set(1.0);
        backRight.set(1.0);
        frontLeft.set(-1.0);
        backLeft.set(-1.0);
    }
    
    public void stop()
    {
        frontRight.set(0.0);
        backRight.set(0.0);
        frontLeft.set(0.0);
        backLeft.set(0.0);
    }
    
    public boolean inRange()
    {
        return (getFeet() < maxDistance) && (getFeet() > minDistance);
    }
}