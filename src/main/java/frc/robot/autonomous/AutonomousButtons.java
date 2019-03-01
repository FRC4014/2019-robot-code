package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.lift.PrintPosition;
import frc.robot.vision.TurnCameraForward;
import frc.robot.vision.TurnCameraReverse;

public class AutonomousButtons {
    public AutonomousButtons (){
        
        // Robot.oi.driveButton4.whenPressed(new TurnCameraForward());
        // Robot.oi.driveButton5.whenPressed(new TurnCameraReverse());
        Robot.oi.driveButton5.whenPressed(new PrintPosition());

        Robot.oi.gButton.whenPressed(new AutonomousGo());
        // Robot.oi.lowHatch0Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 0, true,true)); 
        // Robot.oi.LowHatch2875Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 28.75, true,true));
        // Robot.oi.LowHatch90Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 90, true,true));
        // Robot.oi.LowHatch15125Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 151.25, true,true));
        // Robot.oi.LowHatch180Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 180, true,true));
        // Robot.oi.LowHatch20875Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 208.75, true,true));
        // Robot.oi.LowHatch270Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 270, true,true));
        // Robot.oi.LowHatch33125Button.whenPressed(new AutonomousPrepare(30, 323.8, 143.8, 331.25, true,true));
        // Robot.oi.MidHatch2875Button.whenPressed(new AutonomousPrepare(6.6, 119.6, 119.6, 28.75, true,true));
        // Robot.oi.MidHatch15125Button.whenPressed(new AutonomousPrepare(6.6, 119.6, 119.6, 151.25, true,true));
        // Robot.oi.MidHatch20875Button.whenPressed(new AutonomousPrepare(6.6, 119.6, 119.6, 208.75, true,true));
        // Robot.oi.MidHatch33125Button.whenPressed(new AutonomousPrepare(6.6, 119.6, 119.6, 331.25, true,true));
        // Robot.oi.HighHatch2875Button.whenPressed(new AutonomousPrepare(30, 130.5, 130.5, 28.75, true,true));
        // Robot.oi.HighHatch15125Button.whenPressed(new AutonomousPrepare(30, 130.5, 130.5, 151.25, true,true));
        // Robot.oi.HighHatch20875Button.whenPressed(new AutonomousPrepare(30, 130.5, 130.5, 208.75, true,true));
        // Robot.oi.HighHatch33125Button.whenPressed(new AutonomousPrepare(30, 130.5, 130.5, 331.25, true,true));

        Robot.oi.GrabCargoButton.whenPressed(new AutonomousPrepare(14.8,10.2,48.2,0,false,true));
        Robot.oi.LowCargo0Button.whenPressed(new AutonomousPrepare(24,43.9,124.3,0,false,true));
        Robot.oi.LowCargo90Button.whenPressed(new AutonomousPrepare(24,43.9,124.3,90,false,false));
        Robot.oi.LowCargo270Button.whenPressed(new AutonomousPrepare(24,43.9,124.3,270,false,false));
        Robot.oi.MidCargo90Button.whenPressed(new AutonomousPrepare(2.8,208.2,139.3,90,false,false));
        Robot.oi.MidCargo270Button.whenPressed(new AutonomousPrepare(2.8,208.2,139.3,270,false,false));
        Robot.oi.HighCargo90Button.whenPressed(new AutonomousPrepare(24,181.5,157.8,90,false,false));
        Robot.oi.HighCargo270Button.whenPressed(new AutonomousPrepare(24,181.5,157.8,270,false,false));
    }
}
