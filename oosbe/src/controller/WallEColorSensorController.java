/**
 * 
 */
package controller;

/**
 * @author Till Kobbe
 *
 */
public class WallEColorSensorController implements ColorSensorController {

	/* (non-Javadoc)
	 * @see controller.BaseController#calibrate()
	 */
	@Override
	public void calibrate() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see controller.ColorSensorController#onLine()
	 */
	@Override
	public boolean onLine() {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see controller.ColorSensorController#getLightValue()
	 */
	@Override
	public int getLightValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSetpointValue() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	

}
