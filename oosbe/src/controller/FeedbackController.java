package controller;

public interface FeedbackController {
	/**
	 * returns the normalized value of the Controller
	 * 
	 * @param actual   The actual value
	 * @param setpoint The setpoint value
	 * @return normalized value of the controller
	 */
	double getOutput(int actual, int setpoint);
	
	double getP();
}
