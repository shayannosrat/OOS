/**
 * 
 */
package calibration;

import controller.MotorController;
import controller.WallEMotorController;

/**
 * Calibration class for the color sensor.
 * 
 * Offers calibration method used in the constructor of the controllers.
 * 
 * @author Till Kobbe
 *
 */
public class ColorSensorCalibrator {
	private MotorController motor = WallEMotorController.getInstance();
}
