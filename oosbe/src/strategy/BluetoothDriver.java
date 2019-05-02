package strategy;

import app.Robot;
import commands.CommandInvoker;
import remote.BluetoothReceiver;

public class BluetoothDriver implements Strategy {
    private final int state = 0;

    private Robot robot;

    private CommandInvoker invoker;
    private BluetoothReceiver bluetoothReceiver;

    public BluetoothDriver(Robot robot) {
        this.robot = robot;
        bluetoothReceiver = BluetoothReceiver.getInstance();
    }

    @Override
    public void start() {
        //TODO implementieren der Strategie

        /*

            Es sollen solange Daten aus dem BluetoothReceiver ausgelesen werden, bis sich der State des Robots geändert
            hat. Die gelesenen Daten können dann an den CommandInvoker weitergeleitet werden, der die Commands ausführt

         */
    }

    @Override
    public int getState() {
        return 0;
    }
}
