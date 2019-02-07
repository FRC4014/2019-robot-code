package frc.robot.lowrider;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class RaiseHigh extends Command {

  private long initTimeStamp;
  private boolean topUp;

  public RaiseHigh(){
    // requires(Robot.lowRider);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    System.out.println("Start raise high");
    topUp = false;
    Robot.lowRider.extendHigh();
    initTimeStamp = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    // System.out.println("running raise high");
    if (Robot.oi.raiseHighButton.get() && System.currentTimeMillis() - initTimeStamp > 4000 && Robot.lowRider.isFrontNearFloor()){
      // System.out.println("button pressed");
      if (topUp == false){
        System.out.println("front solenoid extended");
        Robot.lowRider.retractHighFront();
        topUp = true;
        initTimeStamp = System.currentTimeMillis();
      } else if (Robot.lowRider.isBackNearFloor()){
        Robot.lowRider.retractHighBack();
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (!Robot.lowRider.checkBackSolenoid() && System.currentTimeMillis() - initTimeStamp > 1000);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    System.out.println("finish raise high");
  }

}
