package controller;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

/**
 * Controls the motors of Wall-E
 * @author Till Kobbe
 *
 */
public class WallEMotorController implements MotorController {

	protected final NXTRegulatedMotor left, right; 
	protected int speed;
	
	/**
	 * Constructor using the default motor ports
	 */
	public WallEMotorController() {
		left = Motor.B;
		right = Motor.C;
		speed = MAX_SPEED;
	}
	
	/**
	 * Constructor using user specified motors
	 * @param left Left motor
	 * @param right Right motor
	 */
	public WallEMotorController(NXTRegulatedMotor left, NXTRegulatedMotor right) {
		this.left = left;
		this.right = right;
		speed = MAX_SPEED;
	}
	
	/* (non-Javadoc)
	 * @see controller.MotorController#forward()
	 */
	@Override
	public void forward() {
		left.setSpeed(speed);
		right.setSpeed(speed);
		left.forward();
		right.forward();
	}

	/* (non-Javadoc)
	 * @see controller.MotorController#backward()
	 */
	@Override
	public void backward() {
		left.setSpeed(speed);
		right.setSpeed(speed);
		left.backward();
		right.backward();
	}

	/* (non-Javadoc)
	 * @see controller.MotorController#turnLeft()
	 */
	@Override
	public void turnLeft() {
		if(speed > 0)
			left.setSpeed(speed / 2);
		else
			right.setSpeed(MAX_SPEED);
			
		left.forward();
		right.forward();
	}

	/* (non-Javadoc)
	 * @see controller.MotorController#turnRight()
	 */
	@Override
	public void turnRight() {
		if(speed > 0)
			right.setSpeed(speed / 2);
		else
			left.setSpeed(MAX_SPEED);
		
		left.forward();
		right.forward();
	}

	/* (non-Javadoc)
	 * @see controller.MotorController#stop()
	 */
	@Override
	public void stop() {
		left.stop();
		right.stop();
	}

	/* (non-Javadoc)
	 * @see controller.MotorController#setSpeed(int)
	 */
	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

}
