package controller;

import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

/**
 * Controls the motors of Wall-E
 * 
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
	 * 
	 * @param left  Left motor
	 * @param right Right motor
	 */
	private WallEMotorController(NXTRegulatedMotor left, NXTRegulatedMotor right) {
		this.left = left;
		this.right = right;
		left.setSpeed(MAX_SPEED);
		right.setSpeed(MAX_SPEED);

	}

	public static WallEMotorController getInstance() {
		if (instance == null)
			instance = new WallEMotorController();
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#start()
	 */
	@Override
	public void startForward() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.forward();
			};
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.forward();
			};
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void startBackward() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.backward();
			};
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.backward();
			};
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void startRightTurn() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.forward();
			};
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.backward();
			};
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#stop()
	 */
	@Override
	public void stop() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.stop();
			};
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.stop();
			};
		};
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#setLeftSpeed(int)
	 */
	@Override
	public void setLeftSpeed(int speed) {
		left.setSpeed(speed);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#setRightSpeed(int)
	 */
	@Override
	public void setRightSpeed(int speed) {
		right.setSpeed(speed);
	}

	@Override
	public int getRightPosition() {
		return right.getPosition();
	}
	
	@Override
	public int getLeftPosition() {
		return left.getPosition();
	}
	
	@Override
	public void rotateRight(int angle) {
		right.rotate(angle);
	}
	
	@Override
	public void rotateLeft(int angle) {
		left.rotate(angle);
	}
	
	@Override
	public void turnAround() {
		this.setLeftSpeed(MAX_SPEED/2);
		this.setRightSpeed(MAX_SPEED/2);
		this.startRightTurn();
		int preturnPosition = this.getLeftPosition();
		while((this.getLeftPosition()-preturnPosition) <= 430) {
			}
		this.stop();
		this.setLeftSpeed(MAX_SPEED);
		this.setRightSpeed(MAX_SPEED);
	}
}