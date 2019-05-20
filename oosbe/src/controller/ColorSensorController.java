package controller;

/**
 * Controls the color sensor. Extends the BaseController to use the calibrate
 * method. Calibration should be done, when the Constructor is called.
 * 
 * @author Till Kobbe
 *
 */
public interface ColorSensorController extends BaseController {


	/**
	 * Returns the light value from the ColorSensor
	 */
	int getLightValue();

	/**
	 * Returns the setpoint value (value of gray) after calibration is done
	 * 
	 * @return
	 */
	int getSetpointValue();

	/**
	 * Sets the setpoint value for the controller
	 * 
	 * @param value
	 */
	void updateSetpointValue(int value);
}
