package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robotics.LUT;
import robotics.OperatorInterface;
import robotics.subsystems.*;

public class AdjustAngle extends Command
{
    private Launcher launcher;
    //private SmartDashboard dashboard;
    private LUT lut;
    
    private boolean moveUp, finished;
    private double voltage, recommendedVoltage;
    public static final double VOLTAGE_BOT = 4.300;
    public static final double VOLTAGE_TOP = 1.950;
    
    public AdjustAngle(double voltageIn) 
    {   
        recommendedVoltage = voltageIn;
        moveUp = false;
        finished = false;
       
        //dashboard = smartDashboard;
        launcher = Launcher.getInstance();
        requires (launcher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() 
    {
        voltage = launcher.getSensorVoltage();
        moveUp = voltage > recommendedVoltage;
    }

    protected void execute() 
    {
        // this will called repeatedly but relay will be turned on in initialize
        voltage = launcher.getSensorVoltage();
        System.out.println ("At: " + voltage + ", To: " + recommendedVoltage + ", Moving up: " + moveUp + ", isFinished: " + finished + ", This: " + this);
        
        //dashboard.putNumber("Current Voltage: ", voltage);
        
        if (moveUp)
        {
            if ((voltage <= recommendedVoltage) || (voltage <= VOLTAGE_TOP))
            {
                finished = true;
            }
            
            else
            {
                launcher.moveAngleDown();
            }
        }   
        
        else
        {
            if ((voltage >= recommendedVoltage) || (voltage >= VOLTAGE_BOT))
            {
                finished = true;
            }
            
            else
            {
                launcher.moveAngleUp();
            }
        }
    }

    protected boolean isFinished() 
    {
        return finished;
    }

    protected void end() 
    {
        launcher.stopAdjustment();
        finished = false;
    }

    protected void interrupted() 
    {
        launcher.stopAdjustment();
        finished = false;
    }
}
