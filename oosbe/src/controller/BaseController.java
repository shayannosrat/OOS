package controller;

import calibration.Calibrator;

/**
 * Interface for a basic sensor or motor controller.
 * 
 * @author Till Kobbe
 *
 */
public interface BaseController {
	
	/**
	 * Calibrates the controller
	 */
	default void calibrate(Calibrator calibrator) {
		calibrator.runCalibration();
	}
}
