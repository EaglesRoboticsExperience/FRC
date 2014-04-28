package robotics.commands.Autonomous;

import edu.wpi.first.wpilibj.command.*;

import robotics.subsystems.*;
import robotics.commands.Catapult.*;
import robotics.commands.Drivetrain.*;
import robotics.commands.Intake.*;

public class HotOrNot extends Command 
{
    private VisionProcessing vision;
    
    public HotOrNot() 
    {
        vision = VisionProcessing.getInstance();
        requires(vision);
    }

    protected void initialize() {}

    protected void execute() 
    {
        vision.autonomous();
    }

    protected boolean isFinished() 
    {
        return vision.getHot();
    }

    protected void end() {}

    protected void interrupted() {}
}
