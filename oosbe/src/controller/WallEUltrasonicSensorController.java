package controller;

import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;

/**
 * Controls the UltrasonicSensor of WallE
 * 
 * @author Till Kobbe; Shayan Nostrat, Nick G�ller, David R�lleke
 *
 */
public class WallEUltrasonicSensorController implements UltrasonicSensorController {
	private static WallEUltrasonicSensorController instance;

	private final UltrasonicSensor usensor;

	/**
	 * Checks if an instance of WallEUltrasonicSensorController already exists and creates one if not
	 * @return instance of WallEUltrasonicSensorController
	 */
	public static WallEUltrasonicSensorController getInstance() {
		if (instance == null)
			instance = new WallEUltrasonicSensorController();

		return instance;
	}

	/**
	 * Constructor using the default UltrasonicSensor ports
	 */
	private WallEUltrasonicSensorController() {
		usensor = new UltrasonicSensor(SensorPort.S1);
		usensor.continuous();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.UltrasonicSensorController#readData()
	 */
	@Override
	public int readData() {
		return usensor.getDistance();
	}

}
