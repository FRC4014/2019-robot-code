/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.vision;

import edu.wpi.first.wpilibj.command.Command;

public class PrintLook extends Command{
	private final PixyCam pixycam;

	public PrintLook(PixyCam pixycam) {
		super();
		this.pixycam = pixycam;
		requires(pixycam);
	}

	protected void execute() {
		pixycam.testPixy();
	}

	@Override
	protected boolean isFinished() {
		// is never finished
		return false;
	}


}
