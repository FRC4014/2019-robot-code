/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.lift;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Robot;

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
  
  public void moveVertical(double movement){

  }
  public void moveArm(double movement){
    
  }
  public void moveWrist(double movement){
    
  }
  public void stopMoving(){

  }
}
