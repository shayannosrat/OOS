package app;

import constants.RobotState;
import remote.BluetoothReceiver;
import constants.RemoteCode;
import strategy.Strategy;
import strategy.StrategyException;

import java.util.ArrayList;
import java.util.List;

/**
 * WallE Class implements the state machine, initiates the strategies and starts with the "Find Line" strategy
 * 
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 *
 */
public class WallE implements Robot {
	private final BluetoothReceiver bluetoothReceiver;

	private int state;

	private final List<Strategy> strategies = new ArrayList<>();

	public WallE() {
		bluetoothReceiver = BluetoothReceiver.getInstance();

		// Set the default state of the robot to calibrate
		this.state = RobotState.FIND_LINE;
	}
	
	/*
	 * (non-Javadoc)
	 * @see app.Robot#setState(int)
	 */
	@Override
	public void setState(int state) {
		this.state = state;
	}
	
	/*
	 * (non-Javadoc)
	 * @see app.Robot#getState()
	 */
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
	
	/*
	 * (non-Javadoc)
	 * @see app.Robot#registerStrategy(strategy.Strategy)
	 */
	@Override
	public void registerStrategy(Strategy strategy) throws StrategyException {
		for (Strategy s : strategies) {
			if (s.getState() == strategy.getState())
				throw new StrategyException("Duplicate State " + s.getState());
		}

		strategies.add(strategy);
	}

	/*
	 * (non-Javadoc)
	 * @see app.Robot#unregisterStrategy(strategy.Strategy)
	 */
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

	/*
	 * (non-Javadoc)
	 * @see app.Robot#startStrategies()
	 */
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
