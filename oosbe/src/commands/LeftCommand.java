package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Class for driving left
 * 
 * @author dr692175
 *
 */
public class LeftCommand implements Command {

	private MotorController controller;

	public LeftCommand() {
		controller = WallEMotorController.getInstance();
	}

	@Override
	public void execute() {
		controller.setRightSpeed(MotorController.MAX_SPEED);
		controller.setLeftSpeed(MotorController.MAX_SPEED / 2);

	}
}
