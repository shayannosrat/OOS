package strategy;

import app.Robot;
import calibration.Calibrator;
import calibration.WallEColorSensorCalibrator;
import constants.RobotState;
import lejos.nxt.Button;

public class Calibration implements Strategy {
	private final int state = RobotState.CALIBRATION;

	private Robot robot;

	public Calibration(Robot robot) {
		this.robot = robot;
	}

	@Override
	public void start() {
		System.out.println("waiting");

		Calibrator cal = new WallEColorSensorCalibrator();
		
		cal.runCalibration();
		
		robot.setState(RobotState.AUTONOM);
	}

	@Override
	public int getState() {
		return this.state;
	}
}
