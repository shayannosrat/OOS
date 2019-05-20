package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class SpeeddownCommand implements Command {

	public MotorController controller;

	public SpeeddownCommand() {
		this.controller = WallEMotorController.getInstance();
	}

	@Override
	public void execute() {
		controller.setLeftSpeed(controller.getSpeed() - 20);
		controller.setRightSpeed(controller.getSpeed() - 20);
	}

}
