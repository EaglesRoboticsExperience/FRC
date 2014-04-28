package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.camera.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class Autonomous 
{
    private SmartDashboard smartDashboard;
    
    private SpeedController[] driveMotors;
    private SpeedController[] otherMotors;
    
    private AxisCamera camera;
    
    public Autonomous (SmartDashboard sd, SpeedController[] dr, SpeedController[] other)
    {
        smartDashboard = sd;
        driveMotors = dr;
        otherMotors = other;
        
        //camera = AxisCamera.getInstance();
    }
    
    public void work()
    {
        int distance = locateGoal();
        int speed = determineSpeed (distance);
        
        shoot (speed);
    }
    
    public int locateGoal()
    {
        int calculatedDistance = 0;
        
        //code for using the AxisCamera's image to find the distance away
        
        return calculatedDistance;
    }
    
    public int determineSpeed (int distance)
    {
        int speed = 0;
        
        //code for translating a distance into a speed here
        
        return speed;      
    }
    
    public void shoot (double speed)
    {
        otherMotors[0].set (speed);
    }
}
