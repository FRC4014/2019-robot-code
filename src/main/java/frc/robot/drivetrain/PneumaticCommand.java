package frc.robot.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;

public class PneumaticCommand extends Command {

    public PneumaticCommand() {
    }

    @Override
    protected void execute() {
        // our code here to make solenoid go
        RobotMap.SOLENOID_1.set(DoubleSolenoid.Value.kOff);
    }

    @Override
    protected boolean isFinished() {
        return false;
    }



}