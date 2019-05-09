package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class LeftCommand implements Command {

	private MotorController controller = WallEMotorController.getInstance();

    @Override
    public void execute() {
    	controller.setLeftSpeed(MotorController.MAX_SPEED);
    	controller.setRightSpeed((MotorController.MAX_SPEED) / 4);
    }
}
