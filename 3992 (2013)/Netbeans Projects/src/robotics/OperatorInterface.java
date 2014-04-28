package robotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.buttons.*;
import edu.wpi.first.wpilibj.command.*;

import robotics.commands.Launcher.*;
import robotics.commands.Climber.*;
import robotics.commands.Loader.*;

import robotics.subsystems.Launcher;

public class OperatorInterface 
{
    private ControllerJoystick controllerJoystickMovement, controllerJoystickButtons;
    
    private static int JOYSTICK_PORT_MOVEMENT = 1;
    private static int JOYSTICK_PORT_BUTTONS = 2;
    
    private SmartDashboard smartDashboard;
    
    private Compressor compressor;    
    private static OperatorInterface instance = null;
    
    private Command AimHigherInstance, AimLowerInstance;
    private Launcher launcher;

    //controller #1
    private JoystickButton trigger, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix;
    private JoystickButton buttonSeven, buttonEight, buttonNine, buttonTen, buttonEleven, buttonTwelve;
    
    private OperatorInterface()
    {
        smartDashboard = new SmartDashboard();
        controllerJoystickMovement = new ControllerJoystick (JOYSTICK_PORT_MOVEMENT, smartDashboard);
        controllerJoystickButtons = new ControllerJoystick (JOYSTICK_PORT_BUTTONS, smartDashboard);
        
        AimHigherInstance = new AimHigher (1.00);
        AimLowerInstance = new AimLower (1.00);
        
        compressor = new Compressor (1, 1);
        compressor.start();
        
        launcher = Launcher.getInstance();
        launcher.setDefault (smartDashboard);
        
        assignButtons();
    }
    
    public static OperatorInterface getInstance()
    {
        if (instance == null)
        {
            instance = new OperatorInterface();
        }
        
        return instance;
    }
    
    public ControllerJoystick getJoystick()
    {
        return controllerJoystickMovement;
    }
    
    private void assignButtons()
    {
        /**
         *          Controller #2 (not the driving one)
         *          -------------
         * 
         */
        
        
        /**
         *          Controller #1 (driving one)
         *          -------------
         * 
         */
        
        //Trigger = Shoot frisbee, retracts when released
        trigger = new JoystickButton (controllerJoystickMovement, 1);
        trigger.whileHeld(new Shoot());
        
        //Button #3 = Turns the wheels on the launcher off (goes w/ #5)
        buttonThree = new JoystickButton (controllerJoystickMovement, 3);
        buttonThree.whenPressed (new TurnLauncherOff());
        
        //Button #4 = Lowers the launcher's angle via relay (goes w/ 6)
        buttonFour = new JoystickButton (controllerJoystickMovement, 4);
        buttonFour.whileHeld (AimHigherInstance);
        
        //Button #5 = Turns the wheels on the launcher on (goes w/ 3)
        buttonFive = new JoystickButton (controllerJoystickMovement, 5);
        buttonFive.whenPressed (new TurnLauncherOn(1.00)); //full speed
        
        //Button #6 = Raises the launcher's angle via relay (goes w/ 4)
        buttonSix = new JoystickButton (controllerJoystickMovement, 6);
        buttonSix.whileHeld (AimLowerInstance);
        
        buttonEight = new JoystickButton (controllerJoystickMovement, 8);
        buttonEight.whenPressed(new AdjustAngle(AutonomousThreePointer.CENTER_BACK));
        
        //Button #9 = Extends climbing claw (goes w/ 10)
        buttonNine = new JoystickButton (controllerJoystickMovement, 9);
        buttonNine.whenPressed (new ExtendClaw());
        
        //Button #10 = Retracts climbing claw (goes w/ 9)
        buttonTen = new JoystickButton (controllerJoystickMovement, 10);
        buttonTen.whenPressed (new RetractClaw());
        
        //Button #11 = open loader door (goes w/ 12)
        buttonEleven = new JoystickButton(controllerJoystickMovement, 11);
        buttonEleven.whenPressed(new OpenLoaderDoor());
    
        //Button #12 = close loader door (goes w/ 11)
        buttonTwelve = new JoystickButton(controllerJoystickMovement, 12);
        buttonTwelve.whenPressed(new CloseLoaderDoor());
    }
    
    public SmartDashboard getSmartDashboard()
    {
        return smartDashboard;
    }
}