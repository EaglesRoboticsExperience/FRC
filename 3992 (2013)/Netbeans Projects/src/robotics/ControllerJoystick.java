package robotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class ControllerJoystick extends Joystick
{
    private SmartDashboard smartDashboard;
    private double[] joystickValues;
    
    public ControllerJoystick (int port, SmartDashboard sd)
    {        
        super (port);
        
        smartDashboard = sd;
        joystickValues = new double [3];
    }       
     
    public void getJoystickValues()
    {
        double x = getX();
        
        if (Math.abs (x) <= .25) //if number is insignificant, then ignore
            x = 0;
        
        double y = getY();
        
        if (Math.abs (y) <= .25)
            y = 0;
        
        double z = getZ();
        
        if (Math.abs (z) <= .25)
            z = 0;
        
        //y *= -1; //corrects for the default incorrect positioning of the joystick
        //z *= -1;
        
        smartDashboard.putNumber ("X: ", x);
        smartDashboard.putNumber ("Y: ", y);
        smartDashboard.putNumber ("Z: ", z);
        
        joystickValues[0] = x;
        joystickValues[1] = y;
        joystickValues[2] = z;
    }
    
    public double getJoystickX()
    {
        return joystickValues[0];
    }
    
    public double getJoystickY()
    {
        return joystickValues[1];
    }
    
    public double getJoystickZ()
    {
        return joystickValues[2];
    }
}
