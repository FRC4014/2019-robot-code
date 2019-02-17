package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.vision.TurnCameraForward;
import frc.robot.vision.TurnCameraReverse;

public class AutonomousButtons {
    public AutonomousButtons (){
        
        Robot.oi.driveButton4.whenPressed(new TurnCameraForward());
        Robot.oi.driveButton5.whenPressed(new TurnCameraReverse());
        Robot.oi.driveButton6.whenPressed(new AlignByVision(0));

        Robot.oi.position1Button.whenPressed(new AutonomousApproachNDeploy(10, 90, 0, 90, true)); // total guesses here, just for test/show
        Robot.oi.position2Button.whenPressed(new AutonomousApproachNDeploy(20, 45, 30, 0, false));
        Robot.oi.position3Button.whenPressed(new AutonomousApproachNDeploy(10, 110, 60, 180, true));
    }
}
