package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Command Pattern for driving backwards
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class BackwardCommand implements Command {

	private final MotorController controller;

	public BackwardCommand() {
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
		controller.startBackward();
	}
}
