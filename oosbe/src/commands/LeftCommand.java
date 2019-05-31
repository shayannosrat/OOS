package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Command Pattern for driving left
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class LeftCommand implements Command {

	private MotorController controller;

	public LeftCommand() {
		controller = WallEMotorController.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		controller.setRightSpeed(MotorController.MAX_SPEED);
		controller.setLeftSpeed(MotorController.MAX_SPEED / 2);

	}
}
