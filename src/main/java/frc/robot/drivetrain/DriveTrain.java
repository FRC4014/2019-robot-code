package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.drivetrain.DriveByJoystick;
 // is this correct?
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveByJoystick());
  }

  public void drive(Joystick joystick){
    // RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(joystick.getY(), joystick.getX(), joystick.getZ());
    //if using last year's robot, comment the line above and uncomment the line below
    RobotMap.DRIVE_TRAIN_DIFFERENTIAL_DRIVE.arcadeDrive(joystick.getY(), joystick.getZ());
  }

  public void resetEncoders(){
    RobotMap.DRIVE_TRAIN_ENCODER.reset();
  }
}
