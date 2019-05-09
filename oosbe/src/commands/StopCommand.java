package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class StopCommand implements Command {

	private MotorController controller = WallEMotorController.getInstance();

    @Override
    public void execute() {
    	controller.stop();
    }
}
