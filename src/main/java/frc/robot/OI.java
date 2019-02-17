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
  public Button intakeButton = new JoystickButton(driverJoystick, 1);
  public Button outpuButton = new JoystickButton(driverJoystick, 2);
  public Button holdButton = new JoystickButton(driverJoystick, 3);
  public Button driveButton4 = new JoystickButton(driverJoystick, 4);
  public Button driveButton5 = new JoystickButton(driverJoystick, 5);
  public Button driveButton6 = new JoystickButton(driverJoystick, 6);
  public Button driveButton7 = new JoystickButton(driverJoystick, 7);
  public Button driveButton8 = new JoystickButton(driverJoystick, 8);
  public Button raiseLowButton = new JoystickButton(driverJoystick, 11);
  public Button raiseHighButton = new JoystickButton(driverJoystick, 12);
 
  public Joystick mateJoystick = new Joystick(1); 
  // public Button frontleftButton = new JoystickButton(mateJoystick, 7);
  // public Button frontrightButton = new JoystickButton(mateJoystick, 8);
  // public Button backleftButton = new JoystickButton(mateJoystick, 11);
  // public Button backrightButton = new JoystickButton(mateJoystick, 12);
  public Button gButton = new JoystickButton(mateJoystick, 1);
  public Button position1Button = new JoystickButton(mateJoystick, 2);
  public Button position2Button = new JoystickButton(mateJoystick, 3);
  public Button position3Button = new JoystickButton(mateJoystick, 4);


}
