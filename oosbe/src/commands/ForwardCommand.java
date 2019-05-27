package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Class for driving forwards
 * 
 * @author dr692175
 *
 */
public class ForwardCommand implements Command {

	private MotorController controller;

	public ForwardCommand() {
		controller = WallEMotorController.getInstance();
	}

	@Override
	public void execute() {
		controller.setLeftSpeed(MotorController.MAX_SPEED);
		controller.setRightSpeed(MotorController.MAX_SPEED);
		controller.startForward();
	}
}
