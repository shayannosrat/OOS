package remote;

import constants.RemoteCode;
import lejos.nxt.LCD;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import java.io.IOException;
import java.io.InputStream;

/**
 * This class forwards incoming bluetooth signals. It connects on creation
 *
 * @author Till Kobbe; Shayan Nostrat, Nick Göller, David Rölleke
 */
public class BluetoothReceiver extends RemoteCode {

	protected static BluetoothReceiver instance;

	private int data;

	private InputStream dataIn;

	/**
	 * default constructor which connects on creation
	 */
	private BluetoothReceiver() {
		connect();
	}

	/**
	 * Checks if an instance of BluetoothReceiver already exists and creates one if not
	 * @return instance of BluetoothReceiver
	 */
	public static BluetoothReceiver getInstance() {
		if (instance == null)
			instance = new BluetoothReceiver();

		return instance;
	}

	/**
	 * Establish the bluetooth connection
	 */
	private void connect() {
		BTConnection connection;
		LCD.clear();
		LCD.drawString("Waiting", 0, 0);
		connection = Bluetooth.waitForConnection(); // this method is very patient.
		dataIn = connection.openInputStream();
		LCD.clear();
	}

	/**
	 * checks for incoming data via Bluetooth and reads it
	 * @return received data
	 */
	public int readData() {
		data = RemoteCode.NO_DATA_READ;
		try {
			if (dataIn.available() >= 4) {
				byte[] inBytes = new byte[4];
				dataIn.read(inBytes, 0, 4);

				data = (((inBytes[0] & 0xff) << 24) | ((inBytes[1] & 0xff) << 16) | ((inBytes[2] & 0xff) << 8)
						| (inBytes[3] & 0xff));
			}
		} catch (IOException e) {
			return data;
		}
		return data;
	}
}
