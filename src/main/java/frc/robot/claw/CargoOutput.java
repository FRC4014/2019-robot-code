/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.claw;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CargoOutput extends Command {

  private long initTimeStamp;

  public CargoOutput() {
    requires(Robot.claw);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    initTimeStamp = System.currentTimeMillis();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Robot.claw.cargoOutput();
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (System.currentTimeMillis() - initTimeStamp > 10000 || Robot.oi.clawCargoHoldButton.get());
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.claw.cargoHold();
  }

}
