package controller;

/**
 * Controls the motor(s).
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public interface MotorController {

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

	/**
	 * Returns the position of the right motor in degrees
	 * @return degrees which the right motor rotated since reset
	 */
	int getRightPosition();
	
	/**
	 * Returns the position of the left motor in degrees
	 * @return degrees which the left motor rotated since reset
	 */
	int getLeftPosition();
	
//	void rotateRight(int angle);
//	
//	void rotateLeft(int angle);
	
	/**
	 * Turns the robot 180 degrees around its own axis
	 */
	void turnAround();
}