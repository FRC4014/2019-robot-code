package frc.robot.lowrider;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RaiseLow extends Command {

  private long initTimeStamp;
  public RaiseLow() {
    // requires(Robot.lowRider);
  }

  @Override
  protected void initialize() {
    System.out.println("begin raise low");
    Robot.lowRider.extendLow();
    initTimeStamp = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    System.out.println("Running raise low");
    if (Robot.oi.raiseHighButton.get() && System.currentTimeMillis() - initTimeStamp > 100 && Robot.lowRider.isFrontNearFloor()) {
      if (Robot.lowRider.checkFrontSolenoid()){
        Robot.lowRider.retractLowFront();
        initTimeStamp = System.currentTimeMillis();
      } else if (Robot.lowRider.isBackNearFloor()){
        Robot.lowRider.retractLowBack();
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
    System.out.println("finished raise low");
  }
}
