/**
 * 
 */
package calibration;

import controller.MotorController;
import controller.WallEMotorController;
import controller.ColorSensorController;
import controller.WallEColorSensorController;
import java.util.ArrayList;

/**
 * Calibration class for the color sensor.
 * 
 * Offers calibration method used in the constructor of the controllers.
 * 
 * @author Till Kobbe
 *
 */
public class WallEColorSensorCalibrator implements Calibrator {
	private MotorController motor = WallEMotorController.getInstance();
	private ColorSensorController csensor = WallEColorSensorController.getInstance();

	/*
	 * (non-Javadoc)
	 * 
	 * @see calibration.Calibrator#run()
	 */

	@Override
	public void runCalibration() {
		// TODO Auto-generated method stub
		ArrayList<Integer> colorlist = new ArrayList<>();
		motor.setRightSpeed(100);
		motor.setLeftSpeed(0);
		motor.startForward();

		for (int i = 0; i < 400; i++) {
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			colorlist.add(csensor.getLightValue());
			System.out.println(colorlist.get(i));
		}
		Quicksort qs = new Quicksort(colorlist);
		colorlist = qs.getsortedList();
//				for (int i = 0; i < colorlist.size()-1; i++) {
//		            System.out.println(i + 1 + ": " + colorlist.get(i));
//		        }
		int average = 0;
		for (int i = 0; i < 30; i++) {
			average += colorlist.get(i);
		}
		for (int i = 370; i < 400; i++) {
			average += colorlist.get(i);
		}
		average /= 60;
		System.out.println("average: " + average);
		csensor.setSetpointValue(average);
		csensor.setOffset(colorlist.get(0));
		motor.stop();
	}
}