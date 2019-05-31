package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Command Pattern for driving forwards
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class ForwardCommand implements Command {

	private MotorController controller;

	public ForwardCommand() {
		controller = WallEMotorController.getInstance();
	}

	/*
	 * (non-Javadoc)
	 * @see commands.Command#execute()
	 */
	@Override
	public void execute() {
		controller.setLeftSpeed(MotorController.MAX_SPEED);
		controller.setRightSpeed(MotorController.MAX_SPEED);
		controller.startForward();
	}
}
