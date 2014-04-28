package robotics.commands.Launcher;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;

public class AutonomousThreePointer extends CommandGroup 
{
    public static final double CENTER_BACK = 3.111;
    public static final double CENTER_FRONT = 2.181;
    
    public static final double RIGHT_BACK = 3.160;
    public static final double RIGHT_FRONT = 2.600;
    
    public static final double LEFT_FRONT = 2.335; //to modify
    public static final double LEFT_BACK = 3.152;
    
    //2 POINTER - 3.850
    //3 POINTER - 3.800
    
    public AutonomousThreePointer(double voltage)
    {
        addSequential (new AdjustAngle (voltage));
        
        addSequential (new TurnLauncherOn(1.00));
        addSequential (new WaitCommand (2.00));
        
        addSequential (new ExtendPin (0.50));
        addSequential (new RetractPin (0.50));
        addSequential (new WaitCommand (1.00));
        
        addSequential (new ExtendPin (0.50));
        addSequential (new RetractPin (0.50));
        addSequential (new WaitCommand (1.00));
        
        addSequential (new ExtendPin (0.50));
        addSequential (new RetractPin (0.50));
        addSequential (new WaitCommand (1.00));
        
        addSequential (new TurnLauncherOff());
        addSequential (new AdjustAngle(4.04));
    }
}
