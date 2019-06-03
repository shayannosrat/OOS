package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Command Pattern for stopping the robot
 * 
 * @author dr692175
 *
 */
public class StopCommand implements Command {

	private final MotorController controller;

	public StopCommand() {
		this.controller = WallEMotorController.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		controller.stop();

	}

}
