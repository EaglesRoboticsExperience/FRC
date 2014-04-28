 package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

/*
 * 2013 FRC Code for Team 3992
 *      Lead Programmer: Christopher Heung
 *      Contact email: christopherheung@gmail.com
 * 
 */

public class Main extends IterativeRobot 
{
    private ControllerJoystick joystick;
    private SmartDashboard smartDashboard;
    
    private SpeedController[] driveMotors;
    private SpeedController[] otherMotors;
    
    private Drivetrain drivetrain;
    private Autonomous autonomous;
    
    public Main()
    {
        driveMotors = new SpeedController[4];
        driveMotors[0] = new Jaguar(1); //front left
        driveMotors[1] = new Jaguar(2); //back left
        driveMotors[2] = new Jaguar(3); //front right
        driveMotors[3] = new Jaguar(4); //back right
        
        otherMotors = new SpeedController [1];
        
        smartDashboard = new SmartDashboard();
        
        
        //custom-created classes
        joystick = new ControllerJoystick(smartDashboard);
        drivetrain = new Drivetrain(joystick, smartDashboard, driveMotors, otherMotors);
        autonomous = new Autonomous (smartDashboard, driveMotors, otherMotors);
    }
    
    public void teleopInit()
    {
        System.out.println("Teleop Start -- GO!");
    }
    
    public void teleopPeriodic()
    {
        DriverStation ds = DriverStation.getInstance();
        
        drivetrain.drive();
        drivetrain.getJoystick().checkButtons();
        
        int batteryInt = (int)(ds.getBatteryVoltage() * 1000);
        double batteryDouble = batteryInt / 1000.0;
        
        smartDashboard.putString ("Battery : ", batteryDouble + "V");
    }
    
    public void autonomousInit()
    {
        System.out.println ("Autonomous Start -- GO!");
    }
    
    public void autonomousPeriodic()
    {
        autonomous.work();
    }
}