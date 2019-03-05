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

  public double targetAngle;
  public double targetHeightDifference;

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveByJoystick());
  }

  public void drive(Joystick joystick, Double gyroAngle){
    // RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(-joystick.getX(),  joystick.getY(), -joystick.getZ());
    // System.out.println(targetAngle +" "+ targetHeightDifference);s
    // System.out.println(RobotMap.DRIVE_TRAIN_ENCODER.getDistance());
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(-joystick.getX(), joystick.getY(), -joystick.getZ(), -gyroAngle );
  }
  public void driveStraight(double speed){
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(speed, 0, 0);
  }
  public void fl(){
    RobotMap.DRIVE_TRAIN_FRONT_LEFT_MOTOR.set(1);
  }
  public void fr(){
    RobotMap.DRIVE_TRAIN_FRONT_RIGHT_MOTOR.set(1);
  }
  public void bl(){
    RobotMap.DRIVE_TRAIN_BACK_LEFT_MOTOR.set(1);
  }
  public void br(){
    RobotMap.DRIVE_TRAIN_BACK_RIGHT_MOTOR.set(1);
  }
  public void stop(){
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(0, 0, 0);
  }

  public void resetEncoders(){
    RobotMap.DRIVE_TRAIN_ENCODER.reset();
  }

  public void setAngle(double tar){
    targetAngle = tar;
  }
  public double getAngle(){
    return targetAngle;
  }
  public void setHeight(double hight){
    targetHeightDifference = hight;
  }
  public double getHeight(){
    return targetHeightDifference;
  }
}
