/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.autonomous;

import frc.robot.OI;
import frc.robot.vision.LimeLight;
import frc.robot.vision.LookPut;

public class AutonomousButtons {
    OI oi;
    LimeLight limeLight;
    public AutonomousButtons (OI oi, LimeLight limeLight){
        this.oi = oi;
        this.limeLight = limeLight;
        oi.alignButton.whenPressed(new AlignByVision(limeLight));
        oi.lookButton.whenPressed(new LookPut(limeLight));
    }
}
