/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.lowrider;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class RaiseLow extends Command {

  private long initTimeStamp;
  public RaiseLow() {
    requires(Robot.lowRider);
  }

  @Override
  protected void initialize() {
    Robot.lowRider.raiseLow();
    initTimeStamp = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Robot.oi.raiseHighButton.get() && System.currentTimeMillis() - initTimeStamp > 100 && Robot.lowRider.isFrontNearFloor()) {
      if (Robot.lowRider.checkFrontSolenoid()){
        Robot.lowRider.raiseLowFront();
        initTimeStamp = System.currentTimeMillis();
      } else if (Robot.lowRider.isBackNearFloor()){
        Robot.lowRider.raiseLowBack();
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
