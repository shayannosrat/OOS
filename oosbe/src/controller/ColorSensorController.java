package controller;

/**
 * Controls the color sensor. Extends the BaseController to 
 * use the calibrate method.
 * Calibration should be done, when the Constructor is called.
 * 
 * @author Till Kobbe
 *
 */
public interface ColorSensorController extends BaseController {

	/**
	 * Checks if the sensor detects the line
	 * @return 
	 */
	boolean onLine();
	
	/**
	 * Returns the light value from the ColorSensor
	 */
	void getLightValue();
}
