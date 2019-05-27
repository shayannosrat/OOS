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
	double p;
	/**
	 * The cooeficient of the controller
	 */

	public PController(double p) {
		this.p = p;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.FeedbackController#getOutput(int, int)
	 */
	@Override
	public double getOutput(int actual, int setpoint) {
		if((setpoint-actual) < 0)
			return -Math.pow(this.p*Math.abs((double)setpoint - actual),1) / Math.pow((double) setpoint,1);
		else
			return Math.pow(this.p*(double)setpoint - actual,1) / Math.pow((double) setpoint,1);
	}
	
	public double getP() {
		return this.p;
	}
}
