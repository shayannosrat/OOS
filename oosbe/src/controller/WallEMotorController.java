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
	protected static WallEMotorController instance;
	
	/**
	 * Constructor using the default motor ports
	 */
	private WallEMotorController() {
		left = Motor.B;
		right = Motor.C;
		left.setSpeed(MAX_SPEED);
		right.setSpeed(MAX_SPEED);
	}
	
	/**
	 * Constructor using user specified motors
	 * @param left Left motor
	 * @param right Right motor
	 */
	private WallEMotorController(NXTRegulatedMotor left, NXTRegulatedMotor right) {
		this.left = left;
		this.right = right;
		left.setSpeed(MAX_SPEED);
		right.setSpeed(MAX_SPEED);
	}
	
	public static WallEMotorController getInstance() {
		if(instance == null)
			instance = new WallEMotorController();
		return instance;
	}
	
	/*
	 * (non-Javadoc)
	 * @see controller.MotorController#start()
	 */
	@Override
	public void start() {
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
	 * @see controller.MotorController#setLeftSpeed(int)
	 */
	@Override
	public void setLeftSpeed(int speed) {
		left.setSpeed(speed);
	}
	
	/*
	 * (non-Javadoc)
	 * @see controller.MotorController#setRightSpeed(int)
	 */
	@Override
	public void setRightSpeed(int speed) {
		right.setSpeed(speed);
	}

}
