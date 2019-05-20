package strategy;

import app.Robot;
import constants.RobotState;
import controller.ColorSensorController;
import controller.MotorController;
import controller.UltrasonicSensorController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;
import lejos.nxt.ColorSensor;

public class LineLost implements Strategy {
	
	private ColorSensorController csensor = WallEColorSensorController.getInstance();
	private MotorController motor = WallEMotorController.getInstance();
	private UltrasonicSensorController ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
	private Robot robot;
	
	public LineLost(Robot robot) {
		this.robot = robot;
	}

	private final int state = RobotState.LINE_LOST;
	
	@Override
	public void start() {
		System.out.println("Verloren digger");
		motor.setRightSpeed(MotorController.MAX_SPEED);
		motor.setLeftSpeed(MotorController.MAX_SPEED);
				
		int speed = 10;
		int counter = 0;
		
		while(csensor.getLightValue() > csensor.getSetpointValue()) {
			if (this.ultrasonicSensor.readData() <= 10) {
				motor.stop();
				continue;
			}
			motor.setRightSpeed(speed);
			motor.setLeftSpeed(MotorController.MAX_SPEED);
			motor.startForward();
			if(counter == 20) {
				if(speed <= MotorController.MAX_SPEED - 50) {
					speed += 10;
				}
				counter = 0;
			} else {
				counter++;
			}
			
		}
		motor.stop();
		robot.setState(RobotState.AUTONOM);
	}

	@Override
	public int getState() {
		return this.state;
	}

}
