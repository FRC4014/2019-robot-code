package frc.robot.drivetrain;

import com.kauailabs.navx.frc.AHRS;

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

  public void drive(Joystick joystick, Double gyroAngle){
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(-joystick.getX(), joystick.getY(), -joystick.getZ());
    // System.out.println(gyroAngle);
    System.out.println(RobotMap.DRIVE_TRAIN_ENCODER.getDistance());
    // RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(-joystick.getX(), joystick.getY(), -joystick.getZ(), -gyroAngle );
  }

  public void resetEncoders(){
    RobotMap.DRIVE_TRAIN_ENCODER.reset();
  }
}
