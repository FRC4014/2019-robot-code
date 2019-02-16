package frc.robot.autonomous;

import frc.robot.Robot;

public class AutonomousButtons {
    public AutonomousButtons (){
        
        Robot.oi.position1Button.whenPressed(new AutonomousApproachNDeploy(10, 90, 0, 90, true)); // total guesses here, just for test/show
        Robot.oi.position2Button.whenPressed(new AutonomousApproachNDeploy(20, 45, 30, 0, false));
        Robot.oi.position3Button.whenPressed(new AutonomousApproachNDeploy(10, 110, 60, 180, true));
    }
}
