package controller;

/**
 * Controlls the ultrasonic sensor. Extends the BaseController to use the
 * calibrate method. Calibration should be done, when the Constructor is called.
 * 
 * @author Till Kobbe
 *
 */
public interface UltrasonicSensorController {
	int readData();
}
