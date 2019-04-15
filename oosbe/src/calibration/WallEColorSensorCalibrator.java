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
	 * @see calibration.Calibrator#run()
	 */
	
	@Override
	public void runCalibration() {
		// TODO Auto-generated method stub
		ArrayList<Integer> colorlist = new ArrayList();
		motor.setRightSpeed(100);
		motor.setLeftSpeed(0);
		motor.startForward();
		
		
		for(int i=0;i<7;i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			colorlist.add(csensor.getLightValue());
			System.out.println(colorlist.get(i));
		}
		Quicksort qs = new Quicksort(colorlist);
		colorlist = qs.getsortedList();
		for (int i = 0; i < colorlist.size()-1; i++) {
            System.out.println(i + 1 + ": " + colorlist.get(i));
        } 
		motor.stop();
		motor.startBackward();
		try {
			Thread.sleep(1400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		motor.stop();
	}
}
