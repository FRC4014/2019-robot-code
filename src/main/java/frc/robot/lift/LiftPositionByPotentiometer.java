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
  private boolean notVertical;

  private double time;

  public LiftPositionByPotentiometer(double setPointVertical, double setPointArm, double setPointWrist, boolean justVertical,boolean notVertical) {
    this.vertical = RobotMap.LIFT_VERTICAL_POTENTIOMETER;
    this.arm = RobotMap.LIFT_ARM_POTENTIOMETER;
    this.wrist = RobotMap.LIFT_WRIST_POTENTIOMETER;
    this.setPointArm = setPointArm;
    this.setPointVertical = setPointVertical;
    this.setPointWrist = setPointWrist;
    this.justVertical = justVertical;
    this.notVertical = notVertical;
    requires(Robot.lift);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    vp = ap = wp = .5;
    toleranceArm = toleranceWrist = 2;
    toleranceVertical = 5;
    acceptableArm = acceptableWrist = acceptableVertical = false;
    time = System.currentTimeMillis();
    if (justVertical){
      setPointArm = arm.get();
      setPointWrist = wrist.get();
    }
    if (notVertical){
      setPointVertical = vertical.get();
    }
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
    if (!acceptableArm){
      aRcw = (ap * errorArm)/-50;
      aRcw = Math.signum(aRcw) * Math.max(.2, Math.abs(aRcw));
    }
    if (!acceptableVertical){
      vRcw = (vp * errorVertical)/15;
    }
    if (!acceptableWrist){
      wRcw = (wp * errorWrist)/90;
    }
    Robot.lift.moveArm(aRcw);
    Robot.lift.moveVertical(vRcw);
    Robot.lift.moveWrist(wRcw);
    System.out.println("arm error: " + errorArm + " aRcw= " + aRcw);
    System.out.println("vertical error: " + errorVertical + " vRcw= " + vRcw);
    System.out.println("wrist error: " + errorWrist + " wRcw= " + wRcw);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return ((acceptableVertical && justVertical) || (acceptableArm && acceptableWrist && notVertical));
    // return (Robot.oi.DoneButton.get());
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.lift.stopMoving();
  }

}
