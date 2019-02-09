package frc.robot.autonomous;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
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
  private final AHRS navX;
  private double correctionAngleSign = 1;
  private double targetAngle;
  private double heightDifference = 1;
  private double cameraAngle = 0;
  private double xDifference = 0;
  private long timeCheck;

  public AlignByVision(double targetAngle) {
    this.limeLight = Robot.limeLight;
    this.navX = RobotMap.NAVX;
    this.targetAngle = targetAngle;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    previousAngleError = targetAngle - navX.getAngle();
    timeCheck = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double correctionAngle = targetAngle - navX.getAngle();
    double correctionX = limeLight.xOffset(heightDifference,cameraAngle,xDifference);
    acceptableAngle = Math.abs(correctionAngle) < angleTolerance;
    acceptableX = Math.abs(correctionX) < xTolerance;
    double angleRCW = 0;
    double xRCW = 0;

    if (!acceptableAngle){
      angleIntegral += correctionAngle * .02; // .02 is the typical timing for IterativeRobot
      double derivative = (correctionAngle - previousAngleError) / .02; // last years code uses division, but this maybe should be multiplication?
      angleRCW = (p * correctionAngle * correctionAngleSign) + (i * angleIntegral) + (d * derivative);
      timeCheck = System.currentTimeMillis();
    }

    if (!acceptableX){
      xIntegral += correctionX * .02;
      double derivative = (correctionX - previousXError) / .02;
      xRCW = (p * correctionX) + (i * xIntegral) + (d * derivative);
      timeCheck = System.currentTimeMillis();
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
    return (acceptableAngle && acceptableX && System.currentTimeMillis() - timeCheck > 500);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    RobotMap.DRIVE_TRAIN_MECANUM.driveCartesian(0, 0, 0);
  }


}
