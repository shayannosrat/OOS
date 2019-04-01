package oos;

import lejos.nxt.*;
import cal.ColorSensorCal;
import drive.Driver;

public class test {
  public static void testColorSensor() {
    ColorSensor light = new ColorSensor(SensorPort.S4);
    
    while(!Button.ESCAPE.isDown()) {
    	LCD.drawInt(light.getLightValue(), 4, 0, 0);
    	LCD.drawInt(light.getNormalizedLightValue(), 4, 0, 1);
    	LCD.drawInt(SensorPort.S4.readRawValue(), 4, 0, 2);
    	LCD.drawInt(SensorPort.S4.readValue(), 4, 0, 3);
    } 
  }
  
  
  public static void testUltraSonic() {
	  UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S1);

	    while (!Button.ESCAPE.isDown()) {
	      LCD.drawString(sonic.getVendorID(), 0, 0);
	      LCD.drawString(sonic.getProductID(), 0, 1);
	      LCD.drawString(sonic.getVersion(), 0, 2);
	      LCD.drawInt(sonic.getDistance(), 0, 3);
	    }
  }
  
  public static void main(String[] args) {
	  ColorSensorCal.calibrateColorSensor(SensorPort.S4);
	  
	  Driver driver = new Driver(Motor.B, Motor.C, SensorPort.S4);
	  
	  LCD.drawInt(ColorSensorCal.getLineValue(), 0, 0);
	  LCD.drawInt(ColorSensorCal.getExtValue(), 0, 1);
	  LCD.drawString("Stell Wall-E auf die Linie", 0, 2);
	  LCD.drawString("ABFAHRT", 0, 3);
	  
	  Button.waitForAnyPress();
	  
	  LCD.clear();
	  
	  try {
		driver.driveOnLine();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	  LCD.drawInt(ColorSensorCal.getLineValue(), 0, 1);
	  LCD.drawInt(ColorSensorCal.getExtValue(), 0, 2);
	  
	  LCD.drawString("Programm beendet", 0, 3);
	  
	  Button.waitForAnyPress();
	  
	  
  }
}