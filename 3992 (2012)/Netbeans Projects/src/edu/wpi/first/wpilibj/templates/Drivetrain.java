package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Drivetrain
{
    private ControllerJoystick joystick;
    private SmartDashboard smartDashboard;
    
    private SpeedController[] driveMotors;
    private SpeedController[] otherMotors;
    
    private double[] motorSpeeds;
    private double[] joystickAxis;
    
    // [0] = X
    // [1] = Y
    // [2] = Z (twist)
    
    public Drivetrain (ControllerJoystick joy, SmartDashboard sd, SpeedController[] dr, SpeedController[] other)         
    {
        driveMotors = dr;
        joystick = joy;
        smartDashboard = sd;
        
        motorSpeeds = new double [4];
        otherMotors = other;
    }
    
    public void drive()
    {
        joystick.getJoystickValues();
        
        double x = joystick.getX();
        double y = joystick.getY();
        double z = joystick.getZ();
        
        /* [0] = front left
           [1] = back left
           [2] = front right
           [3] = back right */
        
        motorSpeeds = calculateSpeed (x, y, z);
        
        driveMotors[0].set (motorSpeeds[0] * -1); //left motors are both reversed
        driveMotors[1].set (motorSpeeds[1] * -1); //""
        driveMotors[2].set (motorSpeeds[2]);
        driveMotors[3].set (motorSpeeds[3]);
    }
    
    public ControllerJoystick getJoystick()
    {
        return joystick;
    }
    
    public double[] calculateSpeed (double x, double y, double z)
    {
        double[] output = new double [4];
        
        for (int i = 0; i < output.length; i++)
        {
            output[i] = 0.0;
        }
        
        /* [0] = front left
           [1] = back left
           [2] = front right
           [3] = back right */
        
        double first, second, third, fourth;
        first = second = third = fourth = 0;
        
        //vertical and turning only
        
        if (x == 0)
        {
            double motorLeft = (0.75 * y) + (0.50 * z);
            double motorRight = (0.75 * y) - (0.50 * z);
            
            first = motorLeft;
            second = motorLeft;
            third = motorRight;
            fourth = motorRight;
        }
        
        else
        {
            if (y == 0)
            {
                //only sliding horizontal
                
                if (z == 0)
                {
                    double motorSpeed = Math.abs (x);
                
                    first = second = third = fourth = motorSpeed;
                
                    //if sliding to the right
                    if (x > 0)
                    {
                        second = second * -1;
                        third = third * -1;
                    }
                
                    //if sliding to the left
                    else
                    {
                        first = first * -1;
                        fourth = fourth * -1;
                    }
                }
                
                //both sliding horizontal and turning
                
                else
                {
                    double motorSpeed = 0.75 * Math.abs (x);
                    
                    first = second = third = fourth = motorSpeed;
                    
                    //if sliding to the right
                    if (x > 0)
                    {
                        //if sliding to the right and turning right (POV of robot sliding)
                        if (z > 0)
                        {
                            third += (.50 * z);
                        }
                        
                        //if sliding to the right and turning left (POV of robot sliding)
                        else
                        {
                            fourth += (.50 * z);
                        }
                        
                        second = second * -1;
                        third = third * -1;
                    }
                
                    //if sliding to the left
                    else
                    {
                        //if sliding to the left and turning right (POV of robot sliding)
                        if (z > 0)
                        {
                            second += (.50 * z);
                        }
                        
                        //if sliding to the left and turning left (POV of robot sliding)
                        else
                        {
                            first += (.50 * z);
                        }
                        
                        first = first * -1;
                        fourth = fourth * -1;
                    }
                }
            } //refers to if (y == 0)
            
            else
            {
                //both vertical and sliding horizontal
                
                if (z == 0)
                {
                    double motorSpeed = 0.50 * Math.abs (x);
                    
                    //check backward motion
                    
                    first = second = third = fourth = motorSpeed;
                    
                    if (y > 0)
                    {
                        //if sliding to the right
                        if (x > 0)
                        {
                            first += (0.50 * y);
                            fourth += (0.50 * y);
                        }
                    
                        //if sliding to the left
                        else
                        {
                            second += (0.50 * y);
                            third += (0.50 * y);
                        }
                    }
                    
                    else //y < 0
                    {
                        //if sliding to the right
                        if (x > 0)
                        {
                            //abs value is to ensure that, because it is moving in the -y direction,
                            //thus the adding of the value is not negative (going to 0 basically)
                            
                            second += (0.50 * Math.abs (y));
                            third += (0.50 * Math.abs (y));
                        }
                        
                        //if sliding to the left
                        else
                        {
                            first += (0.50 * Math.abs (y)); 
                            fourth += (0.50 * Math.abs (y));
                        }
                        
                        //reverses all motors for backward
                        first *= -1;
                        second *= -1;
                        third *= -1;
                        fourth *= -1;
                    }
                }
                
                //all three (vertical, horizontal, and turning)!
                
                else
                {
                    
                }
            }
        }
        
        output[0] = first;
        output[1] = second;
        output[2] = third;
        output[3] = fourth;
        
        return output;
    }
}