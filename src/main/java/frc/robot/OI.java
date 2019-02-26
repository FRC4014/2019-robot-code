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
  public Button frontleftButton = new JoystickButton(driverJoystick, 4);
  public Button driveButton5 = new JoystickButton(driverJoystick, 5);
  public Button frontrightButton = new JoystickButton(driverJoystick, 6);
  public Button backleftButton = new JoystickButton(driverJoystick, 7);
  public Button backrightButton = new JoystickButton(driverJoystick, 8);
  public Button raiseLowButton = new JoystickButton(driverJoystick, 11);
  public Button raiseHighButton = new JoystickButton(driverJoystick, 12);
 
  public Joystick launchpad1 = new Joystick(1); 
  // public Button frontleftButton = new JoystickButton(mateJoystick, 5);
  // public Button frontrightButton = new JoystickButton(mateJoystick, 3);
  // public Button backleftButton = new JoystickButton(mateJoystick, 4);
  // public Button backrightButton = new JoystickButton(mateJoystick, 6);

  //rocket angle is 28.75 degrees
  public Button gButton = new JoystickButton(launchpad1, 1);
  public Button lowHatch0Button = new JoystickButton(launchpad1, 2);
  public Button LowHatch2875Button = new JoystickButton(launchpad1, 3);
  public Button LowHatch90Button = new JoystickButton(launchpad1, 4);
  public Button LowHatch15125Button = new JoystickButton(launchpad1, 5);
  public Button LowHatch180Button = new JoystickButton(launchpad1, 6);
  public Button LowHatch20875Button = new JoystickButton(launchpad1, 7);
  public Button LowHatch270Button = new JoystickButton(launchpad1, 8);
  public Button LowHatch33125Button = new JoystickButton(launchpad1, 9);
  public Button MidHatch2875Button = new JoystickButton(launchpad1, 10);
  public Button MidHatch15125Button = new JoystickButton(launchpad1, 11);
  public Button MidHatch20875Button = new JoystickButton(launchpad1, 12);
  public Button MidHatch33125Button = new JoystickButton(launchpad1, 13);
  public Button HighHatch2875Button = new JoystickButton(launchpad1, 14);
  public Button HighHatch15125Button = new JoystickButton(launchpad1, 15);
  public Button HighHatch20875Button = new JoystickButton(launchpad1, 16);
  public Button HighHatch33125Button = new JoystickButton(launchpad1, 17);
  public Button GrabCargoButton = new JoystickButton(launchpad1, 18);
  public Button LowCargo0Button = new JoystickButton(launchpad1, 19);
  public Button LowCargo90Button = new JoystickButton(launchpad1, 20);
  public Button LowCargo270Button = new JoystickButton(launchpad1, 21);
  public Button MidCargo90Button = new JoystickButton(launchpad1, 22);
  public Button MidCargo270Button = new JoystickButton(launchpad1, 23);
  public Button HighCargo90Button = new JoystickButton(launchpad1, 24);
  public Button HighCargo270Button = new JoystickButton(launchpad1, 25);








}
