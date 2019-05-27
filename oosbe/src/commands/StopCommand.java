package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Class for stopping the robot
 * 
 * @author dr692175
 *
 */
public class StopCommand implements Command {

	public MotorController controller;

	public StopCommand() {
		this.controller = WallEMotorController.getInstance();
	}

	@Override
	public void execute() {
		controller.stop();

	}

}
