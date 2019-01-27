/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.lift.GoToPosition;

public class AutonomousApproachNDeploy extends CommandGroup {
  /**
   * Add your docs here.
   */
  public AutonomousApproachNDeploy(double verticalPosition, double armPosition, double wristPosition, double approachAngle) {
    // these commands are seperate for now, but it would be faster if bits could be done at the same time
    // we should check how stable the robot is when changing lift positions before we try anything though
    addSequential(new GoToPosition(verticalPosition, armPosition, wristPosition));
    addSequential(new AlignByVision(approachAngle));
    // add stuff for deploying n whatnot
  }
}
