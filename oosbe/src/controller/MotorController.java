package controller;

/**
 * Controls the motor(s).
 * 
 * @author Till Kobbe
 *
 */
public interface MotorController extends BaseController {

	public static final int MAX_SPEED = 400;

	/**
	 * Starts the motor in the forward direction
	 */
	void startForward();

	/**
	 * Starts the motor in the backward direction
	 */
	void startBackward();

	/**
	 * Stops the motor
	 */
	void stop();

	/**
	 * Sets the speed of the left motor
	 * 
	 * @param speed of the motor
	 */
	void setLeftSpeed(int speed);

	/**
	 * Sets the speed of the right motor
	 * 
	 * @param speed of the motor
	 */
	void setRightSpeed(int speed);

	/**
	 * Rotates the NXT by the given angle
	 * 
	 * @param angle
	 */
	void rotate(int angle);
}
