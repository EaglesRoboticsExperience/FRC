package robotics;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.buttons.*;

import robotics.commands.Autonomous.AutonomousCommand;
import robotics.commands.Catapult.*;
import robotics.commands.Intake.*;
import robotics.commands.Shifter.*;

public class OI 
{
    private static OI instance = null;
    
    private Compressor compressor;
    
    private Joystick joy;
    private Button x, a, b, y, leftBumper, rightBumper, leftTrigger, rightTrigger, back;
    
    private OI()
    {
        joy = new Joystick(1);
        
        compressor = new Compressor (1, 1);
        compressor.start();
        
        assignButtons();
    }
    
    private void assignButtons()
    {
        //Michael Buttons
        a = new JoystickButton(joy, 2);
        a.whenPressed(new ShiftSpeed());
        
        b = new JoystickButton(joy, 3);
        b.whenPressed(new ShiftTorque());
        
        rightTrigger = new JoystickButton(joy, 8); //drop the intake
        rightTrigger.whileHeld(new ExtendIntake());
        
        leftTrigger = new JoystickButton(joy, 7); //intake the ball
        leftTrigger.whileHeld(new Forward());
        
        back = new JoystickButton(joy, 9);
        back.whileHeld(new Lock());
        
        leftBumper = new JoystickButton(joy, 5); //expel the ball
        leftBumper.whileHeld(new Reverse());
        
        rightBumper = new JoystickButton(joy, 6);
        rightBumper.whenPressed(new Shoot());
        
        x = new JoystickButton(joy, 1);
        x.whenPressed(new RetractPistons());
        
        //y = new JoystickButton(joy, 4);
        //y.whenPressed(new AutonomousCommand());
        
        /*rightBumper = new JoystickButton(joy, 6);
        rightBumper.whenPressed(new ShiftSpeed());
        
        leftBumper = new JoystickButton(joy, 5);
        leftBumper.whenPressed(new ShiftTorque());

        rightTrigger = new JoystickButton(joy, 8);
        rightTrigger.whileHeld(new ExtendIntake());
        
        a = new JoystickButton(joy, 2);
        a.whenPressed(new RetractPistons());
        
        b = new JoystickButton(joy, 3);
        b.whenPressed(new Shoot());*/
    }
    
    public Joystick getJoystick()
    {
        return joy;
    }
    
    public static OI getInstance()
    {
        if (instance == null)
        {
            instance = new OI();
        }
        return instance;
    }
    
    //// CREATING BUTTONS
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber); 
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}