package strategy;

import app.Robot;
import commands.CommandInvoker;
import constants.RemoteCode;
import constants.RobotState;
import remote.BluetoothReceiver;

public class BluetoothDriver implements Strategy {
    private final int state = RobotState.BLUETOOTH;

    private Robot robot;

    private CommandInvoker invoker;
    private BluetoothReceiver bluetoothReceiver;

    public BluetoothDriver(Robot robot) {
        this.robot = robot;
        bluetoothReceiver = BluetoothReceiver.getInstance();
    }

    @Override
    public void start() {
    	int _code = bluetoothReceiver.readData();
        while(_code != RemoteCode.BLUETOOTH_STATE) {
        	switch(_code) {
        	case RemoteCode.FORWARD: 
        		System.out.println(RemoteCode.FORWARD);
        		//invoker.forward();
        		break;
        	case RemoteCode.BACKWARD:
        		System.out.println(RemoteCode.BACKWARD);
        		//invoker.backward();
        		break;
        	case RemoteCode.LEFT:
        		//invoker.left();
        		break;
        	case RemoteCode.RIGHT:
        		//invoker.right();
        		break;
        	}
        	_code = bluetoothReceiver.readData();
        }
        robot.setState(RobotState.AUTONOM);
    }

    @Override
    public int getState() {
        return 0;
    }
}
