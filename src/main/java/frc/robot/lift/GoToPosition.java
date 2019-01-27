package frc.robot.lift;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;

public class GoToPosition extends CommandGroup {
  /**
   * Add your docs here.
   */
  public GoToPosition(double vertical, double arm, double wrist) {
    if ((arm > 180 && RobotMap.LIFT_ARM_POTENTIOMETER.get() < 180) || (arm < 180 && RobotMap.LIFT_ARM_POTENTIOMETER.get() > 180)){
      // the arm needs to flip arounds, so we should lower the vertical so we have a low center of mass
      // while the arm is flipping around
      addSequential(new LiftPositionByPotentiometer(2 , arm , wrist));
    }
    addSequential(new LiftPositionByPotentiometer(vertical , arm , wrist));
  }
}
