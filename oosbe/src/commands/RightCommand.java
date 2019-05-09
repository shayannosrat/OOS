package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class RightCommand implements Command {

	private MotorController controller = WallEMotorController.getInstance();

    @Override
    public void execute() {
    	controller.setRightSpeed(MotorController.MAX_SPEED);
    	controller.setLeftSpeed((MotorController.MAX_SPEED) / 4);
    }
}
