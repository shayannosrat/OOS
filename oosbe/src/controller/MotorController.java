package controller;

/**
 * Controls the motor(s).
 * 
 * @author Till Kobbe
 *
 */
public interface MotorController extends BaseController {

	public static final int MAX_SPEED = 600;

	/**
	 * Starts the motor in the forward direction
	 */
	void startForward();

	/**
	 * Starts the motor in the backward direction
	 */
	void startBackward();
	
	/**
	 * Starts the motor into a right hand turn
	 */
	void startRightTurn();
	

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

	
	int getRightPosition();
	
	int getLeftPosition();
	
	void rotateRight(int angle);
	
	void rotateLeft(int angle);
	
	void turnAround();
}