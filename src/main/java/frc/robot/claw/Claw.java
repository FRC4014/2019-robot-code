/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.claw;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Claw extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public boolean inHatchPosition;

  public Claw(){
    
  }
  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  public void cargoIntake(){
    RobotMap.CLAW_MOTOR.set(1);
  }
  public void cargoOutput(){
    RobotMap.CLAW_MOTOR.set(-1);
  }
  public void cargoHold(){
    RobotMap.CLAW_MOTOR.set(0);
  }
  public void hatchIntake(){
    RobotMap.CLAW_SOLENOID.set(DoubleSolenoid.Value.kForward);
  }
  public void hatchOutput(){
    RobotMap.CLAW_SOLENOID.set(DoubleSolenoid.Value.kReverse);
  }
}
