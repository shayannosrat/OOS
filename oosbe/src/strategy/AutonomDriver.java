package strategy;

import app.Robot;
import controller.*;
import lejos.nxt.Button;
import lejos.nxt.SensorPort;
import lejos.nxt.SensorPortListener;
import strategy.Strategy;

/**
 * The main driver claas.
 * Controls the robot such as it stays on the line.
 * 
 * @author Till Kobbe
 *
 */
public class AutonomDriver implements Strategy {
	private MotorController 			motor;
	private ColorSensorController		colorSensor;
	private UltrasonicSensorController	ultrasonicSensor;
	
	private FeedbackController			controller;

	private final int state = 1;

	private Robot robot;
	
	public AutonomDriver(Robot r, FeedbackController con) {
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
		motor.setLeftSpeed(motor.MAX_SPEED);
		motor.setLeftSpeed(motor.MAX_SPEED);

		while(robot.getState() == this.state) {
			double output;
			int setpoint = colorSensor.getSetpointValue();

			motor.startForward();
			output = controller.getOutput(colorSensor.getLightValue(), setpoint);
			int newSpeed;
			if (output > 1 || output < -1) {
				newSpeed = 0;
			} else {
				newSpeed = (int) ((1 - Math.abs(output)) * motor.MAX_SPEED);
			}


			if (output > 0) {
				System.out.println("neuer Speed links: " + newSpeed);
				motor.setLeftSpeed(newSpeed);
				motor.setRightSpeed(motor.MAX_SPEED);
			} else {
				System.out.println("neuer Speed rechts: " + newSpeed);
				motor.setRightSpeed(newSpeed);
				motor.setLeftSpeed(motor.MAX_SPEED);
			}
		}
	}
}
