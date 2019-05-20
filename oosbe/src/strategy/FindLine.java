package strategy;

import app.Robot;
import constants.RobotState;
import controller.ColorSensorController;
import controller.FeedbackController;
import controller.MotorController;
import controller.UltrasonicSensorController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;
import lejos.nxt.Button;
import lejos.nxt.ColorSensor;

public class FindLine implements Strategy {

	private MotorController motor;
	private ColorSensorController colorSensor;
	private UltrasonicSensorController ultrasonicSensor;

	private FeedbackController controller;
	
	private final int state = RobotState.FIND_LINE;
	
	private Robot robot;
	
	
	public FindLine(Robot r, FeedbackController con) {
		this.motor = WallEMotorController.getInstance();
		this.colorSensor = WallEColorSensorController.getInstance();
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
		this.controller = con;
		this.robot = r;
	}

	@Override
	public int getState() {
		return this.state;
	}

	@Override
	public void start() {
		System.out.println("Start Searching..");
		try {
			Thread.sleep(100);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
//		while (robot.getState() == this.state) {
//			if (this.ultrasonicSensor.readData() <= 30) {
//				motor.stop();
//				continue;
//			}/(600/430)
//		}
		while(robot.getState() == RobotState.FIND_LINE) {
			motor.startForward();
			colorSensor.calibrate();
			while(ultrasonicSensor.readData() >= 30 || colorSensor.getLightValue() < colorSensor.getSetpointValue() - 50) {
			}
			System.out.println("MAX_SPEED: "+MotorController.MAX_SPEED);
			motor.stop();
			motor.turnAround();
			
			
		}
		System.out.println("Testende");
	}

}

