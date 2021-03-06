package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.vision.LookPut;

public class AutonomousButtons {
    public AutonomousButtons (){
        Robot.oi.alignButton.whenPressed(new AlignByVision(90));// 90 is a placeholder, we need one for each angle a thing can be at
        Robot.oi.lookButton.whenPressed(new LookPut(Robot.limeLight));
        Robot.oi.position1Button.whenPressed(new AutonomousApproachNDeploy(10, 90, 0, 90)); // total guesses here, just for test/show
        Robot.oi.position2Button.whenPressed(new AutonomousApproachNDeploy(20, 45, 30, 0));
        Robot.oi.position3Button.whenPressed(new AutonomousApproachNDeploy(10, 110, 60, 180));
    }
}
