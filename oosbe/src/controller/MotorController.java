package controller;

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
	 * Sets the speed of the motor(s)
	 * @param speed of the motor(s)
	 */
	void setSpeeds(int[] speed);
	
	/**
	 * Calibration is not needed for the motors
	 */
	@Override
	default void calibrate() {}
}
