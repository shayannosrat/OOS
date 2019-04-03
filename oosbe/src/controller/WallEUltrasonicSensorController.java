package controller;

import java.util.ArrayList;

import calibration.Calibrator;

/**
 * Dummy for testing and exaple of using an anonymous Calibrator class
 * 
 * @author Till Kobbe
 *
 */
public class WallEUltrasonicSensorController implements UltrasonicSensorController {
	
	ArrayList<Object> calibrationValue;
	
	private Calibrator calibrator = new Calibrator() {
		@Override
		public void runCalibration() {
			System.out.println(this.toString());
			calibrationValue.add(this);
		}
	};

}
