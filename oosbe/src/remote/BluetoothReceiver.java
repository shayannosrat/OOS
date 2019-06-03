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
 * @author Till Kobbe; Shayan Nostrat, Nick G�ller, David R�lleke
 */
public class BluetoothReceiver extends RemoteCode {

	private static BluetoothReceiver instance;

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
		int data = RemoteCode.NO_DATA_READ;
		try {
			if (dataIn.available() >= 4) {
				byte[] inBytes = new byte[4];
				int read = dataIn.read(inBytes, 0, 4);

				if(read != -1) {
					data = (((inBytes[0]) << 24) | ((inBytes[1]) << 16) | ((inBytes[2]) << 8)
							| (inBytes[3]));
				}
			}
		} catch (IOException e) {
			return data;
		}
		return data;
	}
}
