package driver;

import controller.*;
import lejos.nxt.Button;

/**
 * The main driver claas.
 * Controls the robot such as it stays on the line.
 * 
 * @author Till Kobbe
 *
 */
public class Driver {
	private MotorController 			motor;
	private ColorSensorController		colorSensor;
	private UltrasonicSensorController	ultrasonicSensor;
	
	private FeedbackController			controller;
	
	public Driver(MotorController m, ColorSensorController c, UltrasonicSensorController u, FeedbackController con) {
		this.motor = m;
		this.colorSensor = c;
		this.ultrasonicSensor = u;
		this.controller = con;
	}
	
	/**
	 * Drives the robot on the line
	 */
	public void driveOnLine() {
		while(colorSensor.onLine()) {
			motor.startForward();
		}
		motor.stop();
	}
	
	/**
	 * Drives the robot around the circle
	 */
	public void drive() {
		double output;
		int setpoint = colorSensor.getSetpointValue();
		
		System.out.println("Setpoint is " + setpoint);
		
		Button.waitForAnyPress();
		motor.setLeftSpeed(motor.MAX_SPEED);
		motor.setLeftSpeed(motor.MAX_SPEED);
		
		motor.startForward();
		while(true) {
			output = controller.getOutput(colorSensor.getLightValue(), setpoint);
			int newSpeed;
			if(output > 1 || output < -1) {
				newSpeed = 0;
			} else {
				newSpeed = (int)((1 - Math.abs(output)) * motor.MAX_SPEED);
			}
			
			
			if(output > 0) {
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
