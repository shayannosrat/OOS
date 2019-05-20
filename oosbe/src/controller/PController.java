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

	private int offset, setpoint;

	public PController(double p, int offset, int setpoint) {
		this.p = p;
		this.offset = offset;
		this.setpoint = setpoint;
	}

	public PController(double p) {
		this.p = p;
		this.offset = 0;
		this.setpoint = 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.FeedbackController#getOutput(int, int)
	 */
	@Override
	public double getOutput(int actual, int setpoint) {
		this.setpoint = setpoint;
		actual = actual - this.offset;
		int setpointTemp = setpoint - offset;
		return ((setpoint - actual) * this.p) / ((double) setpoint * this.p);
	}

	public double getOutput(int actual) {
		actual = actual - this.offset;
		int setpointTemp = setpoint - offset;
		return ((setpointTemp - actual) * this.p) / ((double) setpointTemp * this.p);
	}

	@Override
	public void setSetpoint(int setpoint) {
		this.setpoint = setpoint;
	}

	@Override
	public void setOffset(int setpoint) {
		this.offset = offset;
	}

}
