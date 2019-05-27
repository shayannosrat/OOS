package commands;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Class for driving backwards
 * 
 * @author dr692175
 *
 */
public class BackwardCommand implements Command {

	private MotorController controller;

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
