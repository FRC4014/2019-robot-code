/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.vision.LimeLight;

public class AlignByVision extends Command {

  private double p , i , d = 1;
  private double angleIntegral , xIntegral , previousAngleError, previousXError = 0;
  private boolean acceptableAngle =  false;
  private boolean acceptableX = false;
  private double angleTolerance = .1; //Placeholder
  private double xTolerance = 2; //Placeholder
  private final LimeLight limeLight;
  
  private double heightDifference = 1;
  private double cameraAngle = 0;

  public AlignByVision(LimeLight limeLight) {
    this.limeLight = limeLight;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double correctionAngle = limeLight.angle(heightDifference, cameraAngle);
    double correctionX = limeLight.xOffset();
    acceptableAngle = Math.abs(correctionAngle) < angleTolerance;
    acceptableX = Math.abs(correctionX) < xTolerance;
    double angleRCW = 0;
    double xRCW = 0;

    if (!acceptableAngle){
      angleIntegral += correctionAngle * .02; // .02 is the typical timing for IterativeRobot
      double derivative = (correctionAngle - previousAngleError) / .02; // last years code uses division, but this maybe should be multiplication?
      angleRCW = (p * correctionAngle) + (i * angleIntegral) + (d * derivative);
    }

    if (!acceptableX){
      xIntegral += correctionX * .02;
      double derivative = (correctionX - previousXError) / .02;
      xRCW = (p * correctionX) + (i * xIntegral) + (d * derivative);
    }
    System.out.print("Angle RCW = " + angleRCW);
    System.out.println(" x RCW = " + xRCW);
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(0, xRCW, angleRCW);

    previousAngleError = correctionAngle;
    previousXError = correctionX;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (acceptableAngle && acceptableX);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(0, 0, 0);
  }


}
