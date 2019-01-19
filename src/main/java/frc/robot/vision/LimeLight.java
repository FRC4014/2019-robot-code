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
  private NetworkTableEntry twidth = table.getEntry("tlong");
  // private NetworkTableEntry theight = table.getEntry("tvert");
  // private NetworkTableEntry tarea = table.getEntry("ta");


  @Override
  public void initDefaultCommand() { // we probably won't want a default command for this by the end of build season, this is just for testing
    // setDefaultCommand(new LookPut(this));
  }
  public void printImage(){
    double x = Math.toRadians(tx.getDouble(0.0));
    double y = Math.toRadians(ty.getDouble(0.0));
    double width = twidth.getDouble(0.0);
    // double height = theight.getDouble(0.0);
    // double area = tarea.getDouble(0.0);

    double distance = 12.125 / Math.tan(y);
    double beta = (41 * width/320);
    double angleDistance = distance / Math.cos(Math.abs(x - Math.abs(beta/2)));
    double angle = 90 - Math.asin((angleDistance * Math.sin(beta))/14.627);
    double idealBeta = Math.toDegrees(2 * Math.atan(7.336/distance));
    double offBeta = Math.abs(idealBeta - beta);
    
    System.out.print("angle= " + angle);
    System.out.print(" Distance= " + distance);
    System.out.print(" beta=" + beta);
    System.out.print(" ideal Beta= " + idealBeta);
    System.out.println(" off Beta= " + offBeta);

  }
  public double angle(double heightDifference, double cameraAngle){
    double distance = heightDifference / Math.tan(cameraAngle + ty.getDouble(0.0));
    double beta = (41 * twidth.getDouble(0.0)/320);
    double idealBeta = Math.toDegrees(2 * Math.atan(7.336/distance));
    double signGuess = tx.getDouble(0.0)/Math.abs(tx.getDouble(0.0));
    double offBeta = 0;
      if (beta > idealBeta){
        offBeta = 0;
      } else {
        offBeta = idealBeta - beta;
      }
    double offBetaGuess = offBeta * signGuess;
    return offBetaGuess;
  }
  public double xOffset(){
    return tx.getDouble(0.0);
  }
}
