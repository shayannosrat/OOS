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

    public void setInvoker(CommandInvoker invoker) {
        this.invoker = invoker;
    }

    public BluetoothDriver(Robot robot) {
        this.robot = robot;
        bluetoothReceiver = BluetoothReceiver.getInstance();
    }

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
                case RemoteCode.SPEED_UP:
                    invoker.speedUp();
                    break;
                case RemoteCode.SPEED_DOWN:
                    invoker.speedDown();
                    break;
                default:
                    break;
            }
            _code = bluetoothReceiver.readData();
        }
        robot.setState(RobotState.AUTONOM);
    }

    @Override
    public int getState() {
        return this.state;
    }
}
