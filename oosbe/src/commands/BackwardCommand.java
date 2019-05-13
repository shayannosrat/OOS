package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class BackwardCommand implements Command {

	private MotorController controller;

	public BackwardCommand() {
		controller = WallEMotorController.getInstance();
	}

	@Override
	public void execute() {
		controller.setLeftSpeed(MotorController.MAX_SPEED);
		controller.setRightSpeed(MotorController.MAX_SPEED);
		controller.startBackward();
	}
}
