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
import strategy.Strategy;

import java.util.ArrayList;

/**
 * The main driver claas. Controls the robot such as it stays on the line.
 * 
 * @author Till Kobbe
 *
 */
public class AutonomDriver implements Strategy {
	private MotorController motor;
	private WallEColorSensorController colorSensor;
	private UltrasonicSensorController ultrasonicSensor;

	private FeedbackController controller;

	private final int state = RobotState.AUTONOM;

	private Robot robot;

	private ArrayList<Integer> calValues;

	public AutonomDriver(Robot r, FeedbackController con) {
		this.motor = WallEMotorController.getInstance();
		this.colorSensor = WallEColorSensorController.getInstance();
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
		this.controller = con;
		this.robot = r;
		calValues = new ArrayList<>();
	}

	@Override
	public int getState() {
		return this.state;
	}

	@Override
	public void start() {
		System.out.println("Starting Auto");

		motor.setLeftSpeed(MotorController.MAX_SPEED);
		motor.setRightSpeed(MotorController.MAX_SPEED);
		
		this.controller.setOffset(colorSensor.getOffset());

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (robot.getState() == this.state) {
			if (this.ultrasonicSensor.readData() <= 10) {
				motor.stop();
				continue;
			}
			double output;
			int setpoint = colorSensor.getSetpointValue();

			motor.startForward();
			output = controller.getOutput(colorSensor.getLightValue(), setpoint);
			// System.out.println("output: " + output);
			int newSpeed;
			if (output > 1 || output < -1) {
				newSpeed = 0;
			} else {
				newSpeed = (int) ((1 - Math.abs(output)) * MotorController.MAX_SPEED);
			}

			if (output > 0) {

				motor.setLeftSpeed(newSpeed);
				motor.setRightSpeed(MotorController.MAX_SPEED);
			} else {
				motor.setRightSpeed(newSpeed);
				motor.setLeftSpeed(MotorController.MAX_SPEED);
			}

			calValues.add(colorSensor.getLightValue());
			/*
			if(calValues.size() == 5) {
				calibrate();
			}*/
		}
		motor.stop();
	}

	public void calibrate() {
		int newSet = 0;
		while(!calValues.isEmpty()) {
			newSet += calValues.remove(0);
		}
		colorSensor.setSetpointValue(newSet / 5);
	}
}
