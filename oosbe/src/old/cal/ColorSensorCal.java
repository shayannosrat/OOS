package old.cal;


import java.util.List;

import lejos.nxt.*;

public class ColorSensorCal {
	
	protected static int LINE_VALUE;
	protected static int EXT_VALUE;
	
	protected static ColorSensor colorSensor;
	
	private static void setColorSensor(SensorPort port) {
		colorSensor = new ColorSensor(port);
	}
	
	public static int getLineValue() {
		return LINE_VALUE;
	}
	
	public static int getExtValue() {
		return EXT_VALUE;
	}
	
	public static void calibrateColorSensor(SensorPort port) {
		setColorSensor(port);
		
		colorSensor.setFloodlight(true);
		
		int line = 0, ext = 0, temp;
		
		LCD.drawString("Messung auf Linie", 0, 0);
		
		for(int i = 0; i < 3; i++) {
			Button.waitForAnyPress();
			LCD.drawString("Messung " + (i+1) + ":", 0, i+1);
			temp = colorSensor.getNormalizedLightValue();
			LCD.drawInt(temp, 11, i+1);
			line += temp;
		}
		
		LINE_VALUE = line / 3;
		
		Button.waitForAnyPress();
		
		LCD.clear();
		
		LCD.drawString("Messung nicht Linie", 0, 0);
		
		for(int i = 0; i < 3; i++) {
			Button.waitForAnyPress();
			LCD.drawString("Messung " + (i+1), 0, i+1);
			ext += colorSensor.getNormalizedLightValue();
		}
		
		EXT_VALUE = ext / 3;
		
		LCD.clear();
	}

	public static void calcNewLineValue(List<Integer> values) {
		int temp = 0;
		for(Integer i : values) {
			temp += i;
		}
		LINE_VALUE = temp / values.size();
	}
}
