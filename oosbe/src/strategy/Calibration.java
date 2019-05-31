package strategy;

import app.Robot;
import calibration.Calibrator;
import calibration.WallEColorSensorCalibrator;
import constants.RobotState;
import lejos.nxt.Button;

/**
 * Calibrates the robot by initializing the ColorSensorController. At the end of the
 * start()-method the RobotState is set to autonomous
 *  
 * @author Till Kobbe, Shayan Nostrat, Nick Göller, David Rölleke
 */

public class Calibration implements Strategy {
	private final int state = RobotState.CALIBRATION;

	private Robot robot;

	/**
	 * default constructor for Calibration 
	 * @param robot	The robot which should be calibrated by this class
	 */
	public Calibration(Robot robot) {
		this.robot = robot;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#start()
	 */

	@Override
	public void start() {
		System.out.println("waiting");

		Calibrator cal = new WallEColorSensorCalibrator();
		
		cal.runCalibration();
		
		robot.setState(RobotState.AUTONOM);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#getState()
	 */

	@Override
	public int getState() {
		return this.state;
	}
}
