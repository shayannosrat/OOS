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
	
	
	public FindLine(Robot r) {
		this.motor = WallEMotorController.getInstance();
		this.colorSensor = WallEColorSensorController.getInstance();
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
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
		
		int setpoint = colorSensor.getLightValue(), iterator = 0;
		
//		while (robot.getState() == this.state) {
//			if (this.ultrasonicSensor.readData() <= 30) {
//				motor.stop();
//				continue;
//			}/(600/430)
//		}
		while(robot.getState() == RobotState.FIND_LINE) {
			motor.startForward();
			//colorSensor.calibrate();
			while(ultrasonicSensor.readData() >= 30) {
				if(colorSensor.getLightValue() < setpoint - 50 || colorSensor.getLightValue() > setpoint + 50 ) {
					robot.setState(RobotState.CALIBRATION);
					break;
				}
				if(iterator == 10) {
					iterator = 0;
					setpoint = colorSensor.getLightValue();
				}
				iterator++;
				
			}
			if(robot.getState() == RobotState.FIND_LINE) {
				System.out.println("MAX_SPEED: "+MotorController.MAX_SPEED);
				motor.stop();
				motor.turnAround();
			}
			motor.stop();
			
			
		}
		System.out.println("Testende");
	}

}
