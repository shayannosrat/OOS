package controller;

/**
 * Class for a simple P-Controller
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class PController implements FeedbackController {

	private final double p;		//The coefficient of the controller

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
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see controller.FeedbackController#getP()
	 */
	@Override
	public double getP() {
		return this.p;
	}
}
