/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.lowrider;

import edu.wpi.first.wpilibj.DoubleSolenoid;
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
  public boolean ultraSonicDistance() {
    return (RobotMap.ultra.getRangeInches() < 5);
  }
  public boolean checkFrontSolenoid(){
    return (RobotMap.FRONT_LOW_SOLENOID.get() == DoubleSolenoid.Value.kForward);
  }
  public boolean checkBackSolenoid(){
    return (RobotMap.BACK_LOW_SOLENOID.get() == DoubleSolenoid.Value.kForward);
  }

  public void raiseLow(){
    RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
    RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
  }
  public void raiseLowFront(){
    RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
  public void raiseLowBack(){
    RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
  public void raiseHigh(){
    RobotMap.FRONT_HIGH_SOLENOID.set(DoubleSolenoid.Value.kForward);
    RobotMap.BACK_HIGH_SOLENOID.set(DoubleSolenoid.Value.kForward);
    RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
    RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kForward);
  } 
  public void raiseHighFront(){
    RobotMap.FRONT_HIGH_SOLENOID.set(DoubleSolenoid.Value.kReverse);
    RobotMap.FRONT_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
  public void raiseHighBack(){
    RobotMap.BACK_HIGH_SOLENOID.set(DoubleSolenoid.Value.kReverse);
    RobotMap.BACK_LOW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
}
