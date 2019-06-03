package controller;

/**
 * Controls the motor(s).
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public interface MotorController {

	int MAX_SPEED = 600;

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
	 * Turns the robot 180 degrees around its own axis
	 */
	void turnAround();
}