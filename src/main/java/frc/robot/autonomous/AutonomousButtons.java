package frc.robot.autonomous;

import frc.robot.Robot;
import frc.robot.lift.PrintPosition;
import frc.robot.vision.SwitchView;

public class AutonomousButtons {
    public AutonomousButtons (){
        
        Robot.oi.limeLightButton.whenPressed(new SwitchView());
        Robot.oi.justBackButton.whenPressed(new PrintPosition());

        Robot.oi.gButton.whenPressed(new AutonomousGo());
        Robot.oi.lowHatch0Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 0, true,true)); 
        Robot.oi.LowHatch2875Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 28.75, true,true));
        Robot.oi.LowHatch90Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 90, true,true));
        Robot.oi.LowHatch15125Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 151.25, true,true));
        Robot.oi.LowHatch180Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 180, true,true));//2.8,70,38
        Robot.oi.LowHatch20875Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 208.75, true,true));
        Robot.oi.LowHatch270Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 270, true,true));
        Robot.oi.LowHatch33125Button.whenPressed(new AutonomousPrepare(.8, 61, 99, 331.25, true,true));
        Robot.oi.MidHatch2875Button.whenPressed(new AutonomousPrepare(24, 72, 85, 28.75, true,true));
        Robot.oi.MidHatch15125Button.whenPressed(new AutonomousPrepare(24, 72, 85, 151.25, true,true));
        Robot.oi.MidHatch20875Button.whenPressed(new AutonomousPrepare(24,  72, 85, 208.75, true,true));
        Robot.oi.MidHatch33125Button.whenPressed(new AutonomousPrepare(24, 72, 85, 331.25, true,true));
        Robot.oi.HighHatch2875Button.whenPressed(new AutonomousPrepare(25, 135, 12, 28.75, true,true));
        Robot.oi.HighHatch15125Button.whenPressed(new AutonomousPrepare(25, 135, 12, 151.25, true,true));
        Robot.oi.HighHatch20875Button.whenPressed(new AutonomousPrepare(25, 135, 12, 208.75, true,true));
        Robot.oi.HighHatch33125Button.whenPressed(new AutonomousPrepare(25, 135, 12, 331.25, true,true));

        Robot.oi.GrabCargoButton.whenPressed(new AutonomousPrepare(9.8,25,100,0,false,true));
        Robot.oi.LowCargo0Button.whenPressed(new AutonomousPrepare(24,47,133,0,false,true));
        Robot.oi.LowCargo90ButtonRocket.whenPressed(new AutonomousPrepare(24,47,133,90,false,false));
        Robot.oi.LowCargo270ButtonRocket.whenPressed(new AutonomousPrepare(24,47,133,270,false,false));
        Robot.oi.LowCargo90Button.whenPressed(new AutonomousPrepare(24,83,97,90,false,true));
        Robot.oi.LowCargo270Button.whenPressed(new AutonomousPrepare(24,83,97,270,false,true));
        Robot.oi.MidCargo90Button.whenPressed(new AutonomousPrepare(24,105,75,90,false,false));
        Robot.oi.MidCargo270Button.whenPressed(new AutonomousPrepare(24,105,75,270,false,false));
        Robot.oi.HighCargo90Button.whenPressed(new AutonomousPrepare(25,184.7,148,270,false,false));
        Robot.oi.HighCargo270Button.whenPressed(new AutonomousPrepare(25,184.7,148,270,false,false));

        Robot.oi.drivePositionButton.whenPressed(new AutonomousPrepare(24,1,148,0,false,true));
    }
}
