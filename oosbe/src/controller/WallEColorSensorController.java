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
	protected int setpoint;
	protected int offset = 0;

	public static WallEColorSensorController getInstance() {
		if (instance == null)
			instance = new WallEColorSensorController();
		return instance;
	}

	private WallEColorSensorController() {
		csensor = new ColorSensor(SensorPort.S4);
		csensor.setFloodlight(true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#onLine()
	 */
	@Override
	public boolean onLine() {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.ColorSensorController#getLightValue()
	 */
	@Override
	public int getLightValue() {
		return csensor.getNormalizedLightValue() - this.offset;
	}

	@Override
	public void setSetpointValue(int value) {
		setpoint = value;
		return;
	}

	@Override
	public int getSetpointValue() {
		return setpoint - this.offset;
	}

	@Override
	public void setOffset(int offset) {
		this.offset = offset;
		
	}

	@Override
	public int getOffset() {
		return this.offset;
	}
	
}
