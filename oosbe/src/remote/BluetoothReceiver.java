package remote;

import commands.CommandInvoker;
import lejos.nxt.LCD;
import lejos.nxt.Sound;
import lejos.nxt.comm.BTConnection;
import lejos.nxt.comm.Bluetooth;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.PilotProps;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BluetoothReceiver implements remoteMethod {

    protected int _code;
    
    protected float _param1;
    protected float _param2;
    //protected boolean _immediate;

    protected DataInputStream dataIn;

    protected DataOutputStream dataOut;

    protected CommandInvoker invoker;

    public void setInvoker(CommandInvoker invoker) {
    	this.invoker = invoker;
    }
    
    public void go() {
    	connect();
        while (true)
        {
        	System.out.println("reading");
          readData();
          executeCommands();
//          report();
        }
    }
    
    protected void readData() {
        try {
            _code = dataIn.readInt();
            _param1 = dataIn.readFloat();
            _param2 = dataIn.readFloat();
            //_immediate = dataIn.readBoolean();
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    protected  void connect()
    {
        BTConnection connection;
        boolean fail = false;
        LCD.clear();
        LCD.drawString("Waiting", 0, 0);
        connection = Bluetooth.waitForConnection(); // this method is very patient.
        LCD.clear();
        if(!fail)
        {
            LCD.drawString("Connected", 0, 0);
            dataIn = connection.openDataInputStream();
            dataOut = connection.openDataOutputStream();
        }
    }

    protected  void executeCommands() {
    	if(_code == remoteMethod.FORWARD) invoker.forward();
    	else if(_code == remoteMethod.BACKWARD) invoker.backward();
    	else if(_code == remoteMethod.LEFT) invoker.left();
    	else if(_code == remoteMethod.RIGHT) invoker.right();
    	else if(_code == remoteMethod.STOP) invoker.stop();
    	
    }
}
