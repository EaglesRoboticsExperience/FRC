package robotics.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.commands.Drivetrain.*;
import robotics.*;

public class Drivetrain extends Subsystem
{
    private static Drivetrain instance = null;
    
    private RobotDrive robotDrive;
    
    private SpeedController frontLeft;
    private SpeedController backLeft;
    private SpeedController frontRight;
    private SpeedController backRight;
    
    private Drivetrain()
    {
        frontLeft = new Victor (3);
        backLeft = new Victor (4);
        frontRight = new Victor (2);
        backRight = new Victor (1);
        
        robotDrive = new RobotDrive (frontLeft, backLeft, frontRight, backRight);
        
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true); //inverts both left motors, which are
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true); //mechanically inverted (not unusual)
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, false);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
    }
    
    public static Drivetrain getInstance()
    {
        //first call to getInstance()
        if (instance == null)
        {
            instance = new Drivetrain();
            instance.setDefaultCommand(new UseJoystick());
        }
        
        return instance;
    }
    
    public void initDefaultCommand()
    {
        
    }
    
    public void driveWithJoystick()
    {
        ControllerJoystick joystick = OperatorInterface.getInstance().getJoystick();
        
        joystick.getJoystickValues();
        
        double x = joystick.getJoystickX();
        double y = joystick.getJoystickY();
        double z = joystick.getJoystickZ();
        
        x *= -1;
        y *= -1;
        z *= -1;
        
        robotDrive.mecanumDrive_Cartesian(x, y, z, 0);
    }
}
