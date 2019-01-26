package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);
  public Joystick driverJoystick = new Joystick(0);
  public Button alignButton = new JoystickButton(driverJoystick, 1);
  public Button lookButton = new JoystickButton(driverJoystick, 2);
  public Button raiseHighButton = new JoystickButton(driverJoystick, 3);
  public Button raiseLow = new JoystickButton(driverJoystick, 4);
  
  public Joystick mateJoystick = new Joystick(1); // this probably won't be a joystick, so we'll have to change that
  public Button position1Button = new JoystickButton(mateJoystick, 1);
  public Button position2Button = new JoystickButton(mateJoystick, 2);
  public Button position3Button = new JoystickButton(mateJoystick, 3);
  public Button clawCargoIntakeButton = new JoystickButton(mateJoystick, 4);
  public Button clawCargoHoldButton = new JoystickButton(mateJoystick, 5);
  public Button clawCargoOutputButton = new JoystickButton(mateJoystick, 6);
  public Button hatchIntakeButton = new JoystickButton(mateJoystick, 7);
  public Button hatchOutpuButton = new JoystickButton(mateJoystick, 8);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
