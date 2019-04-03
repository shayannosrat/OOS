package controller;

import calibration.Calibrator;

/**
 * Controls the motor(s).
 * 
 * @author Till Kobbe
 *
 */
public interface MotorController extends BaseController {

	public static final int MAX_SPEED = 1200;
	
	/**
	 * Starts the motor(s)
	 */
	void start();
	
	/**
	 * Stops the motor(s)
	 */
	void stop();
	
	/**
	 * Sets the speed of the left motor
	 * @param speed of the motor
	 */
	void setLeftSpeed(int speed);
	
	/**
	 * Sets the speed of the right motor
	 * @param speed of the motor
	 */
	void setRightSpeed(int speed);
	
	/**
	 * Calibration is not needed for the motors
	 */
	@Override
	default void calibrate(Calibrator calibrator) {}
}
