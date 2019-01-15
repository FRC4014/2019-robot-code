/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.vision;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class LimeLight extends Subsystem {
  private NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  private NetworkTableEntry tx = table.getEntry("tx");
  private NetworkTableEntry ty = table.getEntry("ty");
  private NetworkTableEntry twidth = table.getEntry("thoriz");
  private NetworkTableEntry theight = table.getEntry("tvert");


  @Override
  public void initDefaultCommand() { // we probably won't want a default command for this by the end of build season, this is just for testing
    setDefaultCommand(new LookPut(this));
  }
  public void printImage(){
    double x = tx.getDouble(0.0);
    double y = ty.getDouble(0.0);
    double width = twidth.getDouble(0.0);
    double height = theight.getDouble(0.0);

    System.out.print("Limelight");
    System.out.print(" x= " + x);
    System.out.print(" y= " + y);
    System.out.print(" width= " + width);
    System.out.print(" height= " + height);
  }
  public double angle(double heightDifference, double cameraAngle){
    double distance = heightDifference / Math.tan(cameraAngle + tx.getDouble(0.0));
    double beta = (41 * twidth.getDouble(0.0)/320);
    double angleDistance = distance / Math.cos(Math.abs(tx.getDouble(0.0)) - Math.abs(beta/2));
    double angle = 90 - Math.asin((angleDistance * Math.sin(beta))/26.627);
    return angle;
  }
  public double xOffset(){
    return tx.getDouble(0.0);
  }
}
