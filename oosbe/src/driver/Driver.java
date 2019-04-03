package driver;

import controller.*;

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
	
	public Driver(MotorController m, ColorSensorController c, UltrasonicSensorController u) {
		this.motor = m;
		this.colorSensor = c;
		this.ultrasonicSensor = u;
	}
	
	/**
	 * Drives the robot on the line
	 */
	public void driveOnLine() {
		while(colorSensor.onLine()) {
			motor.start();
		}
		motor.stop();
	}
	
	/**
	 * Drives the robot around the circle
	 */
	public void drive() {
		double output;
		int setpoint = colorSensor.getSetpointValue();
		
		motor.start();
		while(true) {
			output = controller.getOutput(colorSensor.getLightValue(), setpoint);
			
			int newSpeed = (int)(Math.abs(output) * motor.MAX_SPEED);
			
			if(output < 0) {
				motor.setLeftSpeed(newSpeed);
			} else {
				motor.setRightSpeed(newSpeed);
			}
		}
	}
}
