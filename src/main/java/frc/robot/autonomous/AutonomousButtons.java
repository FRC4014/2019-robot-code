package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.lift.PrintPosition;
import frc.robot.vision.SwitchView;

public class AutonomousButtons {
    public AutonomousButtons (){
        
        Robot.oi.limeLightButton.whenPressed(new SwitchView());
        // Robot.oi.driveButton4.whenPressed(new TurnCameraForward());
        // Robot.oi.driveButton5.whenPressed(new TurnCameraReverse());
        Robot.oi.hatchInButton.whenPressed(new PrintPosition());

        // Robot.oi.gButton.whenPressed(new AutonomousGo());
        Robot.oi.lowHatch0Button.whenPressed(new AutonomousPrepare(8, 31, 38, 0, true,true)); 
        Robot.oi.LowHatch2875Button.whenPressed(new AutonomousPrepare(8, 31, 38, 28.75, true,true));
        Robot.oi.LowHatch90Button.whenPressed(new AutonomousPrepare(8, 31, 38, 90, true,true));
        Robot.oi.LowHatch15125Button.whenPressed(new AutonomousPrepare(8, 31, 38, 151.25, true,true));
        Robot.oi.LowHatch180Button.whenPressed(new AutonomousPrepare(2.8, 130, 90, 180, true,true));//2.8,70,38
        Robot.oi.LowHatch20875Button.whenPressed(new AutonomousPrepare(8, 31, 38, 208.75, true,true));
        Robot.oi.LowHatch270Button.whenPressed(new AutonomousPrepare(8, 31, 38, 270, true,true));
        Robot.oi.LowHatch33125Button.whenPressed(new AutonomousPrepare(8, 31, 38, 331.25, true,true));
        Robot.oi.MidHatch2875Button.whenPressed(new AutonomousPrepare(9, 214, 34, 28.75, true,true));
        Robot.oi.MidHatch15125Button.whenPressed(new AutonomousPrepare(9, 214, 34, 151.25, true,true));
        Robot.oi.MidHatch20875Button.whenPressed(new AutonomousPrepare(9, 214, 34, 208.75, true,true));
        Robot.oi.MidHatch33125Button.whenPressed(new AutonomousPrepare(9, 214, 34, 331.25, true,true));
        Robot.oi.HighHatch2875Button.whenPressed(new AutonomousPrepare(24, 193, 56, 28.75, true,true));
        Robot.oi.HighHatch15125Button.whenPressed(new AutonomousPrepare(24, 193, 56, 151.25, true,true));
        Robot.oi.HighHatch20875Button.whenPressed(new AutonomousPrepare(24, 193, 56, 208.75, true,true));
        Robot.oi.HighHatch33125Button.whenPressed(new AutonomousPrepare(24, 193, 56, 331.25, true,true));

        Robot.oi.GrabCargoButton.whenPressed(new AutonomousPrepare(9,23,90,0,false,true));
        Robot.oi.LowCargo0Button.whenPressed(new AutonomousPrepare(24,43.9,124.3,0,false,true));
        Robot.oi.LowCargo90ButtonRocket.whenPressed(new AutonomousPrepare(24,43.9,70,90,false,false));
        Robot.oi.LowCargo270ButtonRocket.whenPressed(new AutonomousPrepare(24,43.9,70,270,false,false));
        Robot.oi.LowCargo90Button.whenPressed(new AutonomousPrepare(24,90,40,90,false,true));
        Robot.oi.LowCargo270Button.whenPressed(new AutonomousPrepare(24,90,40,270,false,true));
        Robot.oi.MidCargo90Button.whenPressed(new AutonomousPrepare(2.8,208.2,139.3,90,false,false));
        Robot.oi.MidCargo270Button.whenPressed(new AutonomousPrepare(2.8,208.2,139.3,270,false,false));
        Robot.oi.HighCargo90Button.whenPressed(new AutonomousPrepare(24,181.5,157.8,90,false,false));
        Robot.oi.HighCargo270Button.whenPressed(new AutonomousPrepare(24,181.5,157.8,270,false,false));
    }
}
