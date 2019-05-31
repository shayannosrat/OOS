package strategy;

import app.Robot;
import commands.CommandInvoker;
import constants.RemoteCode;
import constants.RobotState;
import remote.BluetoothReceiver;

/**
 * The user control class. Controls the robot by the orders given via Bluetooth
 * 
 * @author Till Kobbe, Shayan Nostrat, Nick Göller, David Rölleke
 *
 */

public class BluetoothDriver implements Strategy {
	private final int state = RobotState.BLUETOOTH;

	private Robot robot;

	private CommandInvoker invoker;
	private BluetoothReceiver bluetoothReceiver;

	/**
	 * sets the CommandInvoker of the BluetoothDriver to the parametrised invoker
	 * @param invoker 
	 */
	public void setInvoker(CommandInvoker invoker) {
		this.invoker = invoker;
	}

	/**
	 * default constructor of the BluetoothDriver. Creates a BluetoothReceiver upon calling
	 * @param robot	The robot that should be steered by the BluetoothDriver
	 */
	public BluetoothDriver(Robot robot) {
		this.robot = robot;
		bluetoothReceiver = BluetoothReceiver.getInstance();
	}

	/*
	 * (Non-Javadoc)
	 * 
	 * @see strategy.Strategy#start()
	 */
	@Override
	public void start() {
		int _code = bluetoothReceiver.readData();
		while (_code != RemoteCode.BLUETOOTH_STATE) {
			switch (_code) {
			case RemoteCode.FORWARD:
				System.out.println(RemoteCode.FORWARD);
				invoker.forward();
				break;
			case RemoteCode.BACKWARD:
				System.out.println(RemoteCode.BACKWARD);
				invoker.backward();
				break;
			case RemoteCode.LEFT:
				invoker.left();
				break;
			case RemoteCode.RIGHT:
				invoker.right();
				break;
			case RemoteCode.STOP:
				invoker.stop();
				break;
			default:
				break;
			}
			_code = bluetoothReceiver.readData();
		}
		robot.setState(RobotState.AUTONOM);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#getState()
	 */

	@Override
	public int getState() {
		return this.state;
	}
}
