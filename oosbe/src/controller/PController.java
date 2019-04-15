/**
 * 
 */
package controller;

/**
 * Class for a simple P-Controller
 * 
 * @author Till
 *
 */
public class PController implements FeedbackController {

	/**
	 * The cooeficient of the controller
	 */
	private double p;
	
	public PController(double p) {
		this.p = p;
	}
	
	/* (non-Javadoc)
	 * @see controller.FeedbackController#getOutput(int, int)
	 */
	@Override
	public double getOutput(int actual, int setpoint) {
		return ((setpoint - actual) * p)/((double) setpoint * p);
	}

}
