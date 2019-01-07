/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;
import frc.robot.subsystems.DriveTrain;

public class DriveByJoystick extends Command {

  private final DriveTrain driveTrain;
  private final OI oi;

  public DriveByJoystick(DriveTrain driveTrain, OI oi) {
    this.oi = oi;
    this.driveTrain = driveTrain;
    requires(driveTrain);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.drive(oi.driverJoystick);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false; //never gonna stop driving
  }

}
