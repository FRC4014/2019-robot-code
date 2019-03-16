/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class Sandstorm extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Sandstorm(int position) {
    if (position == 2){
      addSequential(new DriveByDistance(.8,50));
      addSequential(new AutonomousPrepare(24,90,40,90,false,true));
    } else {
      addSequential(new DriveByDistance(.8, 192));
      addSequential(new AutonomousPrepare(24,90,40,90,false,true));
      if (position == 1){
        addSequential(new Pivot(-90));
      } else if (position == 3){
        addSequential(new Pivot(90));
      }
    }
    // addSequential(new AutonomousGo());
  }
}
