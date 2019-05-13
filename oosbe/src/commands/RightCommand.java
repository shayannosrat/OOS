package commands;

import controller.MotorController;
import controller.WallEMotorController;

public class RightCommand implements Command {

    private MotorController controller;

    public RightCommand() {
    	controller = WallEMotorController.getInstance();
    }
    
    @Override
    public void execute() {
    	 
    	 
    	    	controller.setRightSpeed(MotorController.MAX_SPEED/2);
    	    	controller.setLeftSpeed(MotorController.MAX_SPEED);

    	    
    }
}
