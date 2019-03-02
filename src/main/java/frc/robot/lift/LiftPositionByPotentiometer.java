package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class LiftPositionByPotentiometer extends Command {

  private double vp; //guesses, modify these
  private double ap;
  private double wp;

  private Potentiometer vertical;
  // private Potentiometer vertical;
  private Potentiometer arm;
  // private Potentiometer wrist;
  private Potentiometer wrist;

  private double toleranceVertical;
  private double toleranceArm;
  private double toleranceWrist;
  private boolean acceptableVertical;
  private boolean acceptableArm;
  private boolean acceptableWrist;
  private double setPointArm;
  private double setPointVertical;
  private double setPointWrist;
  private boolean justVertical;

  public LiftPositionByPotentiometer(double setPointVertical, double setPointArm, double setPointWrist, boolean justVertical) {
    this.vertical = RobotMap.LIFT_VERTICAL_POTENTIOMETER;
    this.arm = RobotMap.LIFT_ARM_POTENTIOMETER;
    this.wrist = RobotMap.LIFT_WRIST_POTENTIOMETER;
    this.setPointArm = setPointArm;
    this.setPointVertical = setPointVertical;
    this.setPointWrist = setPointWrist;
    this.justVertical = justVertical;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    vp = ap = wp = .3;
    toleranceArm = toleranceWrist = 2;
    toleranceVertical = 1;
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
    double errorWrist = setPointWrist - wrist.get();
    acceptableArm = Math.abs(errorArm) < toleranceArm;
    acceptableVertical = Math.abs(errorVertical) < toleranceVertical;
    acceptableWrist = Math.abs(errorWrist) < toleranceWrist;
    if (!acceptableArm && !justVertical){
      aRcw = (ap * errorArm)/360;
    }
    if (!acceptableVertical){
      vRcw = (vp * errorVertical)/30;
    }
    if (!acceptableWrist && !justVertical){
      wRcw = (wp * errorWrist)/360;
    }
    Robot.lift.moveArm(aRcw);
    Robot.lift.moveVertical(vRcw);
    Robot.lift.moveWrist(wRcw);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (acceptableVertical && ((acceptableWrist && acceptableArm) || justVertical));
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lift.stopMoving();
  }

}
