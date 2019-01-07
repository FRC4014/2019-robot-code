/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.DriveByJoystick;
 // is this correct?
/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  private OI oi;

  public DriveTrain(OI oi){
    this.oi = oi;
  }
  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new DriveByJoystick(this,oi));
  }

  public void drive(Joystick joystick){
    RobotMap.driveTrainMecanum.driveCartesian(joystick.getY(), joystick.getX(), joystick.getZ());
  }
}
