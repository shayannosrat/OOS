package controller;

/**
 * Checks the recent lightvalue and returns a new Motorspeed by multiplying the proportional value to the difference of the setpoint
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public interface FeedbackController {
	/**
	 * returns the normalized value of the Controller
	 * 
	 * @param actual   The actual value
	 * @param setpoint The setpoint value
	 * @return normalized value of the controller
	 */
	double getOutput(int actual, int setpoint);
	
	/**
	 * @return the proportional value of the FeedbackController
	 */
	double getP();
}
