package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class ControllerJoystick 
{
    private Joystick joystick;
    private SmartDashboard smartDashboard;
    
    private boolean[] buttons;
    private double[] joystickValues;
    
    private static int NUM_BUTTONS = 12;
    private int lastPressed = 0;
    
    public ControllerJoystick(SmartDashboard sd)
    {        
        joystick = new Joystick (1); //change number based on port
        smartDashboard = sd;
        
        buttons = new boolean [12]; //one for each button on the extreme 3
        joystickValues = new double [3];
        
        //[0] = X
        //[1] = Y
        //[2] = Z
    }       
     
    public void getJoystickValues()
    {
        double x = joystick.getX();
        
        if (Math.abs (x) <= .2) //if number is insignificant, then ignore
            x = 0;
        
        double y = joystick.getY();
        
        if (Math.abs (y) <= .2)
            y = 0;
        
        double z = joystick.getZ();
        
        if (Math.abs (z) <= .2)
            z = 0;
        
        y *= -1; //corrects for the default incorrect positioning of the joystick
        z *= -1;
        
        smartDashboard.putNumber ("X: ", x);
        smartDashboard.putNumber ("Y: ", y);
        smartDashboard.putNumber ("Z: ", z);
        
        joystickValues[0] = x;
        joystickValues[1] = y;
        joystickValues[2] = z;
    }
    
    public double getX()
    {
        return joystickValues[0];
    }
    
    public double getY()
    {
        return joystickValues[1];
    }
    
    public double getZ()
    {
        return joystickValues[2];
    }
    
    public void checkButtons()
    {
        for (int i = 1; i < NUM_BUTTONS; i++)
        {
            if (joystick.getRawButton (i))
            {
                if (lastPressed != i)
                {
                    System.out.println ("Button #" + i + " was pressed.");
                
                    switch (i)
                    {
                        case 11 : 
                            System.out.println ("Button 11!!");
                            break;
                    }
                    
                    lastPressed = i;
                }
            }
        }
    }
}
