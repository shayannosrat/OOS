package controller;

import java.util.ArrayList;

import calibration.Calibrator;

/**
 * Dummy for testing and exaple of using an anonymous Calibrator class
 * 
 * @author Till Kobbe
 *
 */
public class WallEUltrasonicSensorController implements UltrasonicSensorController {
	protected static WallEUltrasonicSensorController instance;

	public static WallEUltrasonicSensorController getInstance() {
		if(instance == null)
			instance = new WallEUltrasonicSensorController();

		return instance;
	}

	private WallEUltrasonicSensorController() {}

}
