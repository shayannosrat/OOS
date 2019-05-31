package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Command Pattern for driving right
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class RightCommand implements Command {

	private MotorController controller;

	public RightCommand() {
		controller = WallEMotorController.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {

		controller.setRightSpeed(MotorController.MAX_SPEED / 2);
		controller.setLeftSpeed(MotorController.MAX_SPEED);

	}
}
