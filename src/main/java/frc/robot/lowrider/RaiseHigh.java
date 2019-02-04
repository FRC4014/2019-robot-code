package frc.robot.lowrider;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


public class RaiseHigh extends Command {

  private long initTimeStamp;

  public RaiseHigh(){
    // requires(Robot.lowRider);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.lowRider.extendHigh();
    initTimeStamp = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.oi.raiseHighButton.get() && System.currentTimeMillis() - initTimeStamp > 100 && Robot.lowRider.isFrontNearFloor()){
      if (Robot.lowRider.checkFrontSolenoid()){
        Robot.lowRider.retractHighFront();
        initTimeStamp = System.currentTimeMillis();
      } else if (Robot.lowRider.isBackNearFloor()){
        Robot.lowRider.retractHighBack();
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (!Robot.lowRider.checkBackSolenoid() && System.currentTimeMillis() - initTimeStamp > 10);
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

}
