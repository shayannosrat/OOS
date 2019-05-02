package app;

import controller.PController;
import strategy.AutonomDriver;
import strategy.BluetoothDriver;
import strategy.StrategyException;


public class Main {
	public static void main(String[] args) {
		// init WallE

		WallE wallE = new WallE();

		// init the Controllers

		PController con = new PController(1000);

		// init Strategys

		BluetoothDriver bluetoothDriver = new BluetoothDriver(wallE);
		AutonomDriver autonomDriver = new AutonomDriver(wallE, con);


		// register strategies
		try {
			wallE.registerStrategy(bluetoothDriver);
			wallE.registerStrategy(autonomDriver);
		} catch(StrategyException e) {
			System.out.println("Strategies couldn't be registered!");
			System.exit(1);
		}

		// start the programm
		wallE.startStrategys();
	}
}
