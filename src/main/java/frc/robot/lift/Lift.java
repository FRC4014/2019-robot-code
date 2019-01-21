package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class Lift extends Subsystem {

  public Lift(){
    Robot.oi.position1Button.whenPressed(new GoToPosition(20,4,1)); //totally not the correct positions
    Robot.oi.position2Button.whenPressed(new GoToPosition(20,90,10));
    Robot.oi.position3Button.whenPressed(new GoToPosition(200,4,25));
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
  
  // we probably need to add max and min speeds, especially the arm motor
  public void moveVertical(double movement){
    RobotMap.LIFT_VERTICAL_MOTOR.set(movement);
  }
  public void moveArm(double movement){
    RobotMap.LIFT_ARM_MOTOR.set(movement);
  }
  public void moveWrist(double movement){
    RobotMap.LIFT_WRIST_MOTOR.set(movement);
  }
  public void stopMoving(){
    RobotMap.LIFT_ARM_MOTOR.set(0);
    RobotMap.LIFT_VERTICAL_MOTOR.set(0);
    RobotMap.LIFT_WRIST_MOTOR.set(0);
  }
}
