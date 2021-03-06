package controller;

import constants.RobotState;
import lejos.nxt.Motor;
import lejos.nxt.NXTRegulatedMotor;

/**
 * Controls the motors of Wall-E
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class WallEMotorController implements MotorController {

	private final NXTRegulatedMotor left;
	private final NXTRegulatedMotor right;
	private static WallEMotorController instance;
	private final WallEColorSensorController colorSensor;

	/**
	 * Constructor using the default motor ports
	 */
	private WallEMotorController() {
		left = Motor.B;
		right = Motor.C;
		left.setSpeed(MAX_SPEED);
		right.setSpeed(MAX_SPEED);
		this.colorSensor = WallEColorSensorController.getInstance();
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
		this.colorSensor = WallEColorSensorController.getInstance();
	}
	
	/**
	 * Checks if an instance of WallEMotorController already exists and creates one if not
	 * @return instance of WallEMotorController
	 */
	public static WallEMotorController getInstance() {
		if (instance == null)
			instance = new WallEMotorController();
		return instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#startForward()
	 */
	@Override
	public void startForward() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.forward();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.forward();
			}
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
	 * @see controller.MotorController#startBackward()
	 */
	@Override
	public void startBackward() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.backward();
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.backward();
			}
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

	/**
	 * Performs a right turn
	 */
	private void startRightTurn() {
		Thread t1 = new Thread() {
			@Override
			public void run() {
				left.forward();
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.backward();
			}
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
			}
		};
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				right.stop();
			}
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

	/**
	 * Returns the Position of the right Motor
	 * @return
	 */
	private int getLeftPosition() {
		return left.getPosition();
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#turnAround()
	 */
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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.MotorController#evade()
	 */
	@Override
	public void evade() {
		int value;
		this.startRightTurn();
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.stop();
		this.setRightSpeed(800);
		this.setLeftSpeed(500);
		this.startForward();
		int average = 0;
		do {
			for(int i = 0; i < 10; i++) {
				average += colorSensor.getLightValue();
			}
			average /= 10;
		}while(average > colorSensor.getSetpointValue() + 50);
		this.stop();
		this.setRightSpeed(0);
		this.setLeftSpeed(500);
		this.startForward();
		do {
		
				value = colorSensor.getLightValue();
		
		}while(value > colorSensor.getSetpointValue() + 50 || value < colorSensor.getSetpointValue() - 50);
		this.stop();
		
	}
}