package controller;

import calibration.Calibrator;

/**
 * Dummy for testing.
 * 
 * @author Till Kobbe
 *
 */
public class WallEUltrasonicSensorController implements UltrasonicSensorController {
	
	private Calibrator calibrator = new Calibrator() {
		@Override
		public void run() {
			System.out.println(this.toString());
		}
	};
	
	/* (non-Javadoc)
	 * @see controller.BaseController#calibrate()
	 */
	@Override
	public void calibrate() {
		calibrator.run();
	}

}
