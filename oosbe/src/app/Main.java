package app;

import calibration.WallEColorSensorCalibrator;
import controller.PController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;
import strategy.AutonomDriver;
import lejos.nxt.Button;
import strategy.BluetoothDriver;


public class Main {
	public static void main(String[] args) {
		// init WallE

		WallE wallE = new WallE();

		// init the Controllers

		PController con = new PController(1000);

		// init Strategys

		BluetoothDriver bluetoothDriver = new BluetoothDriver(wallE);
		AutonomDriver autonomDriver = new AutonomDriver(wallE, con);
	}
}
