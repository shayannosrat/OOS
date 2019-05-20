/**
 * 
 */
package controller;

import lejos.nxt.ColorSensor;
import lejos.nxt.SensorPort;

/**
 * 
 * @author Till Kobbe
 *
 */
public class WallEColorSensorController implements ColorSensorController {

	protected static WallEColorSensorController instance;
	protected ColorSensor csensor;
	protected int setpoint, offset, min, max;

	public static WallEColorSensorController getInstance() {
		if (instance == null)
			instance = new WallEColorSensorController();
		return instance;
	}

	private WallEColorSensorController() {
		csensor = new ColorSensor(SensorPort.S4);
		csensor.setFloodlight(true);
		min = 100;
		max = 400;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#getLightValue()
	 */
	@Override
	public int getLightValue() {
		return csensor.getNormalizedLightValue();
	}

	@Override
	public void updateSetpointValue(int value) {
		if(value > max)
			max = value;
		if(value < min) {
			min = value;
			this.setOffset(value);
		}
		setpoint = (min+max)/2;
	}

	@Override
	public int getSetpointValue() {

		return setpoint;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

}
