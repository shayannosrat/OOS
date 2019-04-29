package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class ForwardCommand implements Command {

	private MotorController controller = WallEMotorController.getInstance();

    @Override
    public void execute() {
    	controller.startForward();
    }
}
