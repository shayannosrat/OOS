package app;

import commands.BackwardCommand;
import commands.CommandInvoker;
import commands.ForwardCommand;
import commands.LeftCommand;
import commands.RightCommand;
import commands.StopCommand;
import controller.FeedbackController;
import controller.PController;
import strategy.AutonomDriver;
import strategy.BluetoothDriver;
import strategy.Calibration;
import strategy.FindLine;
import strategy.LineLost;
import strategy.StopStrategy;
import strategy.StrategyException;

/**
 * Main Class to start the program.
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class Main {

	/**
	 * Main Method Create all the needed resources and then starts the Robot
	 * 
	 * @param args given arguments
	 */
	public static void main(String[] args) {
		// init WallE

		WallE wallE = new WallE();

		// init the controllers
		CommandInvoker invoker = new CommandInvoker();
		invoker.registerForwardCommand(new ForwardCommand());
		invoker.registerStopCommand(new StopCommand());
		invoker.registerLeftCommand(new LeftCommand());
		invoker.registerRightCommand(new RightCommand());
		invoker.registerBackwardCommand(new BackwardCommand());

		FeedbackController con = new PController(0.85);

		// init strategies

		BluetoothDriver bluetoothDriver = new BluetoothDriver(wallE);
		AutonomDriver autonomDriver = new AutonomDriver(wallE, con);
		Calibration calibration = new Calibration(wallE);
		LineLost lost = new LineLost(wallE);
		FindLine find = new FindLine(wallE);
		StopStrategy stop = new StopStrategy(wallE);

		bluetoothDriver.setInvoker(invoker);

		// register strategies
		try {
			wallE.registerStrategy(bluetoothDriver);
			wallE.registerStrategy(autonomDriver);
			wallE.registerStrategy(calibration);
			wallE.registerStrategy(lost);
			wallE.registerStrategy(find);
			wallE.registerStrategy(stop);
		} catch (StrategyException e) {
			System.out.println("Strategies couldn't be registered! " + e.toString());
			System.exit(1);
		}

		// start the program
		wallE.startStrategies();
	}
}
