/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.SPI;
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

  public static final WPI_TalonSRX DRIVE_TRAIN_FRONT_RIGHT_MOTOR = new WPI_TalonSRX(CAN.DRIVE_TRAIN_MOTOR_FRONT_RIGHT);
  public static final WPI_TalonSRX DRIVE_TRAIN_BACK_RIGHT_MOTOR = new WPI_TalonSRX(CAN.DRIVE_TRAIN_MOTOR_BACK_RIGHT);
  public static final WPI_TalonSRX DRIVE_TRAIN_FRONT_LEFT_MOTOR = new WPI_TalonSRX(CAN.DRIVE_TRAIN_MOTOR_FRONT_LEFT);
  public static final WPI_TalonSRX DRIVE_TRAIN_BACK_LEFT_MOTOR = new WPI_TalonSRX(CAN.DRIVE_TRAIN_MOTOR_BACK_LEFT);
  
  public static final MecanumDrive DRIVE_TRAIN_MECANUM = new MecanumDrive(DRIVE_TRAIN_FRONT_LEFT_MOTOR, DRIVE_TRAIN_BACK_LEFT_MOTOR, DRIVE_TRAIN_FRONT_RIGHT_MOTOR, DRIVE_TRAIN_BACK_RIGHT_MOTOR);
  
  //the following stuff is for a standard arcade drive for use when testing on 2018 bot
  private static final SpeedControllerGroup DRIVE_TRAIN_LEFT_MOTOR_GROUP = new SpeedControllerGroup(DRIVE_TRAIN_FRONT_LEFT_MOTOR, DRIVE_TRAIN_BACK_LEFT_MOTOR);
  private static final SpeedControllerGroup DRIVE_TRAIN_RIGHT_MOTOR_GROUP = new SpeedControllerGroup(DRIVE_TRAIN_FRONT_RIGHT_MOTOR, DRIVE_TRAIN_BACK_RIGHT_MOTOR);
  public static final DifferentialDrive DRIVE_TRAIN_DIFFERENTIAL_DRIVE = new DifferentialDrive(DRIVE_TRAIN_LEFT_MOTOR_GROUP, DRIVE_TRAIN_RIGHT_MOTOR_GROUP);

  public static AHRS NAVX = new AHRS(SPI.Port.kMXP);


  public static void init(){
    NAVX.reset();
  }
}
