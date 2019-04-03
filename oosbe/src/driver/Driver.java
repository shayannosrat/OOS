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
	
	public Driver(MotorController m, ColorSensorController c, UltrasonicSensorController u) {
		this.motor = m;
		this.colorSensor = c;
		this.ultrasonicSensor = u;
	}
	
	/**
	 * Drives the robot on the line
	 */
	public void drive() {
		while(colorSensor.onLine()) {
			motor.start();
		}
		motor.stop();
	}
}
