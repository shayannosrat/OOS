
package remote;

import commands.CommandInvoker;
import lejos.nxt.LCD;
import lejos.nxt.Sound;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BlutoothReceiver implements remoteMethod {

    protected int _code;

    protected DataInputStream dataIn;

    protected OutputStream os;

    protected CommandInvoker invoker;

    protected void readData() {
        try {
            _code = dataIn.readInt();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    protected void connect()
    {
        BTConnection connection;
        boolean fail = false;
        LCD.clear();
        LCD.drawString("Waiting", 0, 0);
        connection = Bluetooth.waitForConnection(); // this method is very patient.
        LCD.clear();
        try
        {
            byte [] hello = new byte[32];
            int len = connection.read(hello, hello.length);
            if (len != 3 || hello[0] != 'R' || hello[1] != 'C' || (hello[2] != 'P'))
            {
                fail = true;
                LCD.drawString("Console no h/s    ", 0, 0);
                connection.close();
                return;
            }
            else
            {
                os = connection.openOutputStream();
                os.write(hello);
                os.flush();
            }
        }
        catch (Exception e)
        {
            LCD.drawString("connection error " + e.getMessage(), 0, 0);
        }
        if(!fail)
        {
            LCD.drawString("Connected", 0, 0);
            dataIn = connection.openDataInputStream();
            Sound.beepSequence();
        }
    }

    protected void executeCommands() {
        /*
        if(_code == remoteMethod.FORWARD) invoker.forward();
        else if(_code == remoteMethod.BACKWARD) invoker.backward();
        else if(_code == remoteMethod.LEFT) invoker.left();
        else if(_code == remoteMethod.RIGHT) invoker.right();
        */

        System.out.println(_code);
    }
}
