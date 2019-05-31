package controller;

/**
 * Controlls the ultrasonic sensor. Extends the BaseController to use the
 * calibrate method. Calibration should be done, when the Constructor is called.
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public interface UltrasonicSensorController {
	
	/**
	 * Reads the distance value of the UltrasonicSensor
	 * @return distance value in cm
	 */
	int readData();
}
