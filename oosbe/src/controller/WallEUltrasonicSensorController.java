package controller;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * Dummy for testing and exaple of using an anonymous Calibrator class
 * 
 * @author Till Kobbe
 *
 */
public class WallEUltrasonicSensorController implements UltrasonicSensorController {
	protected static WallEUltrasonicSensorController instance;

	private UltrasonicSensor usensor;

	public static WallEUltrasonicSensorController getInstance() {
		if (instance == null)
			instance = new WallEUltrasonicSensorController();

		return instance;
	}

	private WallEUltrasonicSensorController() {
		usensor = new UltrasonicSensor(SensorPort.S1);
		usensor.continuous();
	}

	@Override
	public int readData() {
		return usensor.getDistance();
	}

}
