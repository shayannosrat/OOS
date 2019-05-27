package app;

import constants.RobotState;
import remote.BluetoothReceiver;
import constants.RemoteCode;
import strategy.Strategy;
import strategy.StrategyException;

import java.util.ArrayList;
import java.util.List;

public class WallE implements Robot {
	private BluetoothReceiver bluetoothReceiver;

	private int state;

	private List<Strategy> strategies = new ArrayList<>();

	public WallE() {
		bluetoothReceiver = BluetoothReceiver.getInstance();

		// Set the default state of the robot to calibrate
		this.state = RobotState.FIND_LINE;
	}

	@Override
	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int getState() {
		int data = bluetoothReceiver.readData();
		if (data == RemoteCode.BLUETOOTH_STATE) {
			this.state = RobotState.BLUETOOTH;
			System.out.println("State");
		} else if (data == RemoteCode.EXIT_STATE) {
			this.state = RobotState.EXIT_PROGRAM;
		}
		return this.state;
	}

	@Override
	public void registerStrategy(Strategy strategy) throws StrategyException {
		for (Strategy s : strategies) {
			if (s.getState() == strategy.getState())
				throw new StrategyException("Duplicate State " + s.getState());
		}

		strategies.add(strategy);
	}

	@Override
	public Strategy unregisterStrategy(Strategy strategy) throws StrategyException {
		for (Strategy s : strategies) {
			if (s.getState() == strategy.getState()) {
				strategies.remove(s);
				return s;
			}
		}
		throw new StrategyException("Strategy not found");
	}

	@Override
	public void startStrategies() {

		while (this.state != RobotState.EXIT_PROGRAM) {
			for (Strategy s : strategies) {
				if (s.getState() == this.state) {
					System.out.println("Strategy " + this.state);
					s.start();
				}

			}
		}

		System.exit(0);
	}
}
