package calibration;

/**
 * Simple Interface for a calibrator.
 * 
 * Sadly LeJOS doesn't support lambdas, so they can only be implemented directly
 * or via an anonymous class
 * 
 * @author Till Kobbe
 *
 */
public interface Calibrator {

	/**
	 * Method for running the calibration.
	 */
	void runCalibration();
}
