package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.vision.LookPut;

public class AutonomousButtons {
    public AutonomousButtons (){
        Robot.oi.alignButton.whenPressed(new AlignByVision(90));// 90 is a placeholder, we need one for each angle a thing can be at
        Robot.oi.lookButton.whenPressed(new LookPut(Robot.limeLight));
    }
}
