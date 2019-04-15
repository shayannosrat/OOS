package app;

import calibration.WallEColorSensorCalibrator;
import controller.PController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;
import driver.Driver;
import lejos.nxt.Button;



public class Main {
	public static void main(String[] args) {
		/*
		 * Praktikum 2 Tests: 
		 * 
		 * 1. Neue Struktur, alte Funktion
		 * 2. Kalibierungen laufen richtig
		 * 3. Ultrasonic Sensor 
		 * 4. Algo für Linienfahrt
		 */
		System.out.println("Hello Wall-E");
		Button.waitForAnyPress();
		
		WallEColorSensorController csensor = WallEColorSensorController.getInstance();
		System.out.println("ColorSensor created");
		WallEMotorController motor = WallEMotorController.getInstance();
		System.out.println("MotorController created");
		WallEUltrasonicSensorController ultra = new WallEUltrasonicSensorController();
		System.out.println("UltraSonicSensor created");
		PController pcon = new PController(1000);		
		WallEColorSensorCalibrator csensorCal = new WallEColorSensorCalibrator();
		csensorCal.runCalibration();
		System.out.println("Calibration completed");
		
		Driver drive = new Driver(motor, csensor, ultra, pcon);
		
		drive.drive();
	}
}
