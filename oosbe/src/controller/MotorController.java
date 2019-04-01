package controller;

/**
 * Controls the motor(s).
 * 
 * @author Till Kobbe
 *
 */
public interface MotorController extends BaseController {

	/**
	 * Move the motor(s) forward
	 */
	void forward();
	
	/**
	 * Move the motor(s) backward
	 */
	void backward();
	
	/**
	 * Performs a left turn
	 */
	void turnLeft();
	
	/**
	 * Performs a right turn
	 */
	void turnRight();
	
	/**
	 * Stops the motor(s)
	 */
	void stop();
	
	/**
	 * Sets the speed of the motor(s)
	 * @param speed of the motor(s)
	 */
	void setSpeed(int speed);
	
	/**
	 * Calibration is not needed for the motors
	 */
	@Override
	default void calibrate() {}
}
