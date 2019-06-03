package controller;

/**
 * Controls the color sensor. Extends the BaseController to use the calibrate
 * method. Calibration should be done, when the Constructor is called.
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 */
public interface ColorSensorController {

	/**
	 * Returns the light value from the ColorSensor
	 * 
	 * @return The recent value of the ColorSensor 
	 */
	int getLightValue();

	/**
	 * Returns the setpoint value (value of gray) after calibration is done
	 * 
	 * @return The setpoint value which determines whether the ColorSensor is looking at white or black
	 */
	int getSetpointValue();

	/**
	 * Sets the setpoint value for the controller
	 * 
	 * @param value	setpoint is set to a value which determines whether the ColorSensor is looking at white or black
	 */
	void setSetpointValue(int value);
	
	/**
	 * Sets the offset value of the controller
	 * @param offset
	 */
	void setOffset(int offset);
	
	/**
	 * Returns the offset
	 * @return lowest light value recorded in calibration
	 */
	int getOffset();
}
