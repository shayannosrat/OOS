package remote;

import constants.RemoteCode;
import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * This class forwards incoming bluetooth signals. It connects on creation
 *
 * @author Till Kobbe
 */
public class BluetoothReceiver extends RemoteCode {

    protected static BluetoothReceiver instance;

    private int data;
    protected float _param1;
    protected float _param2;

    private DataInputStream dataIn;

    private BluetoothReceiver() {
        connect();
    }

    public static BluetoothReceiver getInstance() {
        if(instance == null)
            instance = new BluetoothReceiver();

        return instance;
    }

    /**
     * Establish the bluetooth connection
     */
    private void connect()
    {
        BTConnection connection;
        LCD.clear();
        LCD.drawString("Waiting", 0, 0);
        connection = Bluetooth.waitForConnection(); // this method is very patient.
        dataIn = connection.openDataInputStream();
        LCD.clear();
    }

    public int readData() {
        try {
            data = dataIn.readInt();
            _param1 = dataIn.readFloat();
            _param2 = dataIn.readFloat();
        } catch(IOException e) {
            System.out.println("Cannot read Integer Data from incoming Bluetooth Connection");
        }

        return data;
    }

    protected  void executeCommands() {
        if(_code == remoteMethod.FORWARD) invoker.forward();
        else if(_code == remoteMethod.BACKWARD) invoker.backward();
        else if(_code == remoteMethod.LEFT) invoker.left();
        else if(_code == remoteMethod.RIGHT) invoker.right();
        else if(_code == remoteMethod.STOP) invoker.stop();

    }
}
