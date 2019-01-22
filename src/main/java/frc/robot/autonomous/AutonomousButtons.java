package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.vision.LookPut;

public class AutonomousButtons {
    public AutonomousButtons (){
        Robot.oi.alignButton.whenPressed(new AlignByVision(Robot.limeLight));
        Robot.oi.lookButton.whenPressed(new LookPut(Robot.limeLight));
    }
}
