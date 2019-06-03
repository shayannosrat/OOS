package strategy;

import java.util.ArrayList;

import app.Robot;
import constants.RobotState;
import controller.UltrasonicSensorController;
import controller.WallEColorSensorController;
import controller.WallEUltrasonicSensorController;

public class StopStrategy implements Strategy {

	private Robot robot;
	private UltrasonicSensorController ultrasonicSensor;
	
	public StopStrategy(Robot robot) {
		this.robot = robot;
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
	}
	
	@Override
	public void start() {
		int sum = 0;
		while(sum <= 20) {
			sum = 0;
			for(int i = 0; i < 10; i++) {
				sum += ultrasonicSensor.readData();
			}
			sum /= 10;
		}
		robot.setState(RobotState.AUTONOM);
	}

	@Override
	public int getState() {
		return RobotState.STOP;
	}

}
