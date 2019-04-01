package drive;

import lejos.nxt.*;

import java.util.ArrayList;
import java.util.List;

import cal.ColorSensorCal;


public class Driver {
	protected NXTRegulatedMotor left, right;
	protected ColorSensor sensor;
	protected int EPS = 50;
	
	public Driver(NXTRegulatedMotor left, NXTRegulatedMotor right, SensorPort port) {
		this.left = left;
		this.right = right;
		this.sensor = new ColorSensor(port);
	} 
	
	/**
	 * Erste Implementierung noch alles andere als Final
	 * ohne irgend eine Form von Design-Mustern.
	 * 
	 * Liest Werte vom ColorSensor und gleicht mit 
	 * @throws InterruptedException 
	 */
	public void driveOnLine() throws InterruptedException {
		List<Integer> messwerte = new ArrayList<>();
		int normalValue = sensor.getNormalizedLightValue(), index = 0;
				
		while(testLineVal(normalValue, EPS)) {
			// Driving
			left.setSpeed(100);
			right.setSpeed(100);
			left.forward();
			right.forward();
			
			//Aktuell halten des LINE_VALUE
			if(index < 10) {
				messwerte.add(normalValue);
				LCD.drawInt(index, 0, index);
				index++;
			}
			else {
				ColorSensorCal.calcNewLineValue(messwerte);
				messwerte.clear();
				index = 0;
			}
			Thread.sleep(500);
			
			normalValue = sensor.getNormalizedLightValue();
		}
		
		left.stop();
		right.stop();
		
		if(Button.ENTER.isDown()) {
			left.stop();
			right.stop();
			return;
		}
	}
	
	private boolean testLineVal(int value, int eps) {
		return (value <= ColorSensorCal.getLineValue() + eps)
				&& (value >= ColorSensorCal.getLineValue() - eps);
	}
}
