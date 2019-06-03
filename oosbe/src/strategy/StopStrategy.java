package strategy;

import java.util.ArrayList;

import app.Robot;
import constants.RobotState;
import controller.MotorController;
import controller.UltrasonicSensorController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;

public class StopStrategy implements Strategy {

	private final MotorController motor;
	private Robot robot;
	private UltrasonicSensorController ultrasonicSensor;
	
	public StopStrategy(Robot robot) {
		this.robot = robot;
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
		this.motor = WallEMotorController.getInstance();
	}
	
	@Override
	public void start() {
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += ultrasonicSensor.readData();
		}
		sum /= 10;
		if(sum<=20) {
			motor.evade();
		}
		robot.setState(RobotState.AUTONOM);
	}

	@Override
	public int getState() {
		return RobotState.STOP;
	}

}
