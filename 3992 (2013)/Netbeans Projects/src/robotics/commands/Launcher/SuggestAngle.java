package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import robotics.LUT;
import robotics.OperatorInterface;
import robotics.subsystems.*;

public class SuggestAngle extends Command
{
    private Launcher launcher;
    private SmartDashboard dashboard;
    //private LUT lut;
    
    private boolean finished = false;
    
    private double distance, voltage, recommendedVoltage;
    
    public SuggestAngle(SmartDashboard smartDashboard, double duration) 
    {   
        super (duration);
        
        dashboard = smartDashboard;
        //lut = new LUT();
        recommendedVoltage = -1.0; //default value
        
        launcher = Launcher.getInstance();
        requires (launcher);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    protected void initialize() 
    {
        //distance = launcher.getDistance();
        voltage = launcher.getSensorVoltage();
        
        /*if (distance != -1.0)
        {
            recommendedVoltage = lut.getVoltage (distance);
        }*/   
        
        //dashboard.putNumber("Current Distance: ", distance);
        dashboard.putNumber("Current Voltage: ", voltage);
        //dashboard.putNumber("Recommended Voltage: ", recommendedVoltage);
        
        //System.out.println ("Initialized suggestAngle()");
    }

    protected void execute() 
    {
        
    }

    protected boolean isFinished() 
    {
        return isTimedOut();
        //return true;
        //return finished;
    }

    protected void end() 
    {
        // nothing to do     
    }

    protected void interrupted() 
    {
        
    }
}
