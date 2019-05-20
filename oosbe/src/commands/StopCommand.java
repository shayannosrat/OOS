package commands;

import controller.MotorController;
import controller.WallEMotorController;

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
