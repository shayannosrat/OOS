package controller;

/**
 * Interface for a basic sensor or motor controller.
 * 
 * @author Till Kobbe
 *
 */
public interface BaseController {
	
	/**
	 * Calibrate the controller if needed.
	 */
	void calibrate();
}
