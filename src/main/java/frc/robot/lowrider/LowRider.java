package frc.robot.lowrider;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class LowRider extends Subsystem {
  public LowRider(){
    Robot.oi.raiseHighButton.whenPressed(new RaiseHigh());
    Robot.oi.raiseLow.whenPressed(new RaiseLow());
  }
  @Override
  public void initDefaultCommand() {
  }
  public boolean isFrontNearFloor() {
    return true;
    // return (RobotMap.FRONT_RIGHT_ULTRASONIC.getRangeInches() < 5)
    // && (RobotMap.FRONT_LEFT_ULTRASONIC .getRangeInches() < 5);
  }
  public boolean isBackNearFloor() {
    return true;
    // return (RobotMap.BACK_RIGHT_ULTRASONIC.getRangeInches() < 5)
    // && (RobotMap.BACK_LEFT_ULTRASONIC .getRangeInches() < 5);
  }
  public boolean checkFrontSolenoid(){
    // return (RobotMap.FRONT_LOW_SOLENOID.get() == DoubleSolenoid.Value.kForward);
    return true;
  }
  public boolean checkBackSolenoid(){
    // return (RobotMap.BACK_LOW_SOLENOID.get() == DoubleSolenoid.Value.kForward);
    return true;
  }

  public void extendLow(){
    RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
    System.out.println("begin delay");
    Timer.delay(.1);
    RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
  }
  public void retractLowFront(){
    RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
  public void retractLowBack(){
    RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
  public void extendHigh(){
    RobotMap.BACK_HIGH_SOLENOID.set(DoubleSolenoid.Value.kForward);
    // RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
    Timer.delay(.125);
    RobotMap.FRONT_HIGH_SOLENOID.set(DoubleSolenoid.Value.kForward);
    // RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
  } 
  public void retractHighFront(){
    RobotMap.FRONT_HIGH_SOLENOID.set(DoubleSolenoid.Value.kReverse);
    // RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
    System.out.println("retracting front");
  }
  public void retractHighBack(){
    RobotMap.BACK_HIGH_SOLENOID.set(DoubleSolenoid.Value.kReverse);
    // RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
    System.out.println("retracting back");

  }
}
