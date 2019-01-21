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
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.
  }
}
