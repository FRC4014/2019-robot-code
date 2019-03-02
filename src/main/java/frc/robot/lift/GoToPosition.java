package frc.robot.lift;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class GoToPosition extends CommandGroup {
  /**
   * Add your docs here.
   */
  public GoToPosition(double vertical, double arm, double wrist) {
    if ((arm > 180 && RobotMap.LIFT_ARM_POTENTIOMETER.get() < 180) || (arm < 180 && RobotMap.LIFT_ARM_POTENTIOMETER.get() > 180)){
      // the arm needs to flip arounds, so we should raise the lift beacause I guess we have to?
      addSequential(new LiftPositionByPotentiometer(24 , arm , wrist, true));
    }
    addSequential(new LiftPositionByPotentiometer(vertical , arm , wrist, false));
  }
}
