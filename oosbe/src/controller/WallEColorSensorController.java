package controller;

import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

/**
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class WallEColorSensorController implements ColorSensorController {

	private static WallEColorSensorController instance;
	private final ColorSensor csensor;
	private int setpoint;
	private int offset = 0;

	/**
	 * Checks if an instance of WallEColorSensorController already exists and creates one if not
	 * @return instance of WallEColorSensorController
	 */
	public static WallEColorSensorController getInstance() {
		if (instance == null)
			instance = new WallEColorSensorController();
		return instance;
	}

	/**
	 * Constructor using the default ColorSensor port
	 * Also sets the floodlight of the sensor
	 */
	private WallEColorSensorController() {
		csensor = new ColorSensor(SensorPort.S4);
		csensor.setFloodlight(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#getLightValue()
	 */
	@Override
	public int getLightValue() {
		if(csensor.getNormalizedLightValue() - this.offset < 0)
			return 0;
		return csensor.getNormalizedLightValue() - this.offset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#setSetpointValue()
	 */
	@Override
	public void setSetpointValue(int value) {
		this.setpoint = value;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#getSetpointValue()
	 */
	@Override
	public int getSetpointValue() {
		return setpoint - this.offset;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#setOffset()
	 */
	@Override
	public void setOffset(int offset) {
		this.offset = offset;
		System.out.println("Real offset " + this.offset);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#getOffset()
	 */
	@Override
	public int getOffset() {
		return this.offset;
	}
	
}
