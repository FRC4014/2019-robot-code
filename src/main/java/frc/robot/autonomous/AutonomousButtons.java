/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.vision.LookPut;

public class AutonomousButtons {
    public AutonomousButtons (){
        Robot.oi.alignButton.whenPressed(new AlignByVision(Robot.limeLight));
        Robot.oi.lookButton.whenPressed(new LookPut(Robot.limeLight));
    }
}
