/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

public class Pivot extends Command {

  private double p, i, d, integral, previousError, setPoint = 0;
  private boolean acceptable = false;

  private final AHRS navX;
  private double maxSpeed, minSpeed;
  private double tolerance;

  public Pivot(double setPoint) {
    this.navX = RobotMap.NAVX;
    this.setPoint = setPoint;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    maxSpeed = .8; // just guessing here, based on last year's code
    minSpeed = .2;
    tolerance = 1;
    integral = previousError = 0;
    acceptable = false;
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    final double angle = navX.getAngle();
    double error = setPoint - angle;
    double rcw = 0;
    double rotation = 0;
    acceptable = Math.abs(error) < tolerance;
    if (!acceptable){
      integral += error * .02;
      double derivative = (error - previousError) / .02;
      rcw = (p * error) + (i * integral) + (d * derivative);
      double modRcw = Math.abs(rcw) / Math.abs(setPoint) * .25;
      rotation = Math.max(minSpeed, Math.min(modRcw, maxSpeed));
      rotation = rcw < 0 ? -rotation : rotation;
      RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(0, 0, rotation);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return acceptable;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(0, 0, 0);
  }

}
