/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.MecanumDrive;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {

  public static WPI_TalonSRX driveTrainFrontLeftMotor = new WPI_TalonSRX(1);
  public static WPI_TalonSRX driveTrainFrontRightMotor = new WPI_TalonSRX(2);
  public static WPI_TalonSRX driveTrainBackLeftMotor = new WPI_TalonSRX(3);
  public static WPI_TalonSRX driveTrainBackRightMotor = new WPI_TalonSRX(4);
  public static MecanumDrive driveTrainMecanum = new MecanumDrive(driveTrainFrontLeftMotor, driveTrainBackLeftMotor, driveTrainFrontRightMotor, driveTrainBackRightMotor);
  
  //the following stuff is for a standard arcade drive for use when testing on 2018 bot
  private static SpeedControllerGroup driveTrainLeftMotorGroup = new SpeedControllerGroup(driveTrainFrontLeftMotor, driveTrainBackLeftMotor);
  private static SpeedControllerGroup driveTrainRightMotorGroup = new SpeedControllerGroup(driveTrainFrontRightMotor, driveTrainBackRightMotor);
  public static DifferentialDrive driveTrainDifferentialDrive = new DifferentialDrive(driveTrainLeftMotorGroup, driveTrainRightMotorGroup);
}
