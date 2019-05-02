package remote;

import constants.RemoteCodes;
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
public class BluetoothReceiver extends RemoteCodes {

    protected static BluetoothReceiver instance;

    private int data;

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
    public void connect()
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
        } catch(IOException e) {
            System.out.println("Cannot read Integer Data from incoming Bluetooth Connection");
        }

        return data;
    }
}
