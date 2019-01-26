package frc.robot.lift;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftPositionByPotentiometer extends Command {

  private double vp; //guesses, modify these
  private double ap;
  private double wp;

  private Potentiometer vertical;
  private Potentiometer arm;
  // private Potentiometer wrist;
  private Encoder wrist;

  private double toleranceVertical;
  private double toleranceArm;
  private double toleranceWrist;
  private boolean acceptableVertical;
  private boolean acceptableArm;
  private boolean acceptableWrist;
  private double setPointArm;
  private double setPointVertical;
  private double setPointWrist;

  public LiftPositionByPotentiometer(double setPointVertical, double setPointArm, double setPointWrist) {
    this.vertical = RobotMap.LIFT_VERTICAL_POTENTIOMETER;
    this.arm = RobotMap.LIFT_ARM_POTENTIOMETER;
    this.wrist = RobotMap.LIFT_WRIST_ENCODER;
    this.setPointArm = setPointArm;
    this.setPointVertical = setPointVertical;
    this.setPointWrist = setPointWrist;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    vp = ap = wp = .7;
    toleranceArm = toleranceWrist = 1;
    toleranceVertical = .5;
    acceptableArm = acceptableWrist = acceptableVertical = false;
    requires(Robot.lift);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double vRcw, aRcw, wRcw;
    vRcw = aRcw = wRcw = 0;
    double errorVertical = setPointVertical - vertical.get();
    double errorArm = setPointArm - arm.get();
    double errorWrist = setPointWrist - wrist.getDistance();
    acceptableArm = Math.abs(errorArm) < toleranceArm;
    acceptableVertical = Math.abs(errorVertical) < toleranceVertical;
    acceptableWrist = Math.abs(errorWrist) < toleranceWrist;
    if (!acceptableArm){
      aRcw = (ap * errorArm)/360;
    }
    if (!acceptableVertical){
      vRcw = (vp * errorVertical)/360;
    }
    if (!acceptableWrist){
      wRcw = (wp * errorWrist)/360;
    }
    Robot.lift.moveArm(aRcw);
    Robot.lift.moveVertical(vRcw);
    Robot.lift.moveWrist(wRcw);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (acceptableArm && acceptableVertical && acceptableWrist);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lift.stopMoving();
  }

}
