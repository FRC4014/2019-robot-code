/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.vision;

public class PixyPacket {
	private int Signature;
	private int X;
	private int Y;
	private int Width;
	private int Height;
	/**
	 * @return the signature
	 */
	public int getSignature() {
		return Signature;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return Height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.Height = height;
	}
	/**
	 * @return the width
	 */
	public int getWidth() {
		return Width;
	}
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.Width = width;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return Y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.Y = y;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return X;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.X = x;
	}
	/**
	 * @param signature the signature to set
	 */
	public void setSignature(int signature) {
		this.Signature = signature;
	}
}
