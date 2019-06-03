package strategy;

import app.Robot;
import constants.RobotState;
import controller.ColorSensorController;
import controller.MotorController;
import controller.UltrasonicSensorController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;

/**
 * Searches the line if it was never found before.
 * the robot drives in a straight line until it detects an object infront of it. It then
 * turns a bit less than 180� around and goes straight on until it detects another object.
 * 
 * @author Till Kobbe, Shayan Nostrat, Nick G�ller, David R�lleke
 */

public class FindLine implements Strategy {

	private final MotorController motor;
	private final ColorSensorController colorSensor;
	private final UltrasonicSensorController ultrasonicSensor;

	private final Robot robot;
	
	/**
	 * default constructor for FindLine. Creates a Motor-, ColorSensor- and UltrasonicSensorController
	 * upon calling.
	 * @param r The robot which the FindLine strategy should steer
	 */
	public FindLine(Robot r) {
		this.motor = WallEMotorController.getInstance();
		this.colorSensor = WallEColorSensorController.getInstance();
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
		this.robot = r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#start()
	 */

	@Override
	public int getState() {
		return RobotState.FIND_LINE;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#getState()
	 */
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
				motor.stop();
				motor.turnAround();
			}
			motor.stop();
		}
	}

}
