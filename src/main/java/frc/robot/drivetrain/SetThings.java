/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetThings extends Command {
  private double height;
  private double angle;
  public SetThings(double h, double a) {
    this.height = h;
    this.angle = a;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.driveTrain.setAngle(angle);
    Robot.driveTrain.setHeight(height);
  }



  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

}