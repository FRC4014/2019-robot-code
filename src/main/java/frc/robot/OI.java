package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public Joystick driverJoystick = new Joystick(0);
  public Button alignButton = new JoystickButton(driverJoystick, 1);
  public Button lookButton = new JoystickButton(driverJoystick, 2);
  public Button raiseHighButton = new JoystickButton(driverJoystick, 3);
  public Button raiseLow = new JoystickButton(driverJoystick, 4);
 

  
  public Joystick mateJoystick = new Joystick(1); 
  // public Button frontleftButton = new JoystickButton(mateJoystick, 7);
  // public Button frontrightButton = new JoystickButton(mateJoystick, 8);
  // public Button backleftButton = new JoystickButton(mateJoystick, 11);
  // public Button backrightButton = new JoystickButton(mateJoystick, 12);
  public Button position1Button = new JoystickButton(mateJoystick, 1);
  public Button position2Button = new JoystickButton(mateJoystick, 2);
  public Button position3Button = new JoystickButton(mateJoystick, 3);
  public Button clawCargoIntakeButton = new JoystickButton(mateJoystick, 4);
  public Button clawCargoHoldButton = new JoystickButton(mateJoystick, 5);
  public Button clawCargoOutputButton = new JoystickButton(mateJoystick, 6);
  public Button hatchIntakeButton = new JoystickButton(mateJoystick, 7);
  public Button hatchOutpuButton = new JoystickButton(mateJoystick, 8);

}
