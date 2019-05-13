package remote;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import lejos.pc.comm.NXTCommFactory;
import lejos.pc.comm.NXTConnector;

public class BluetoothSender {

	
	private NXTConnector con;
	
    
    private boolean _isMoving;
    private float _distance;
    private float _angle;

	private DataInputStream dataIn;
	private DataOutputStream dataOut;
	
	public boolean connect(String name, String address) {
	    con = new NXTConnector();

		boolean connected = con.connectTo(name, address, NXTCommFactory.BLUETOOTH);
	    System.out.println(" connect result " + connected);
	    if(!connected )
	    {
	      System.out.println("handshake failed - is RCPilot running?");
	     return false;
	    }
	    
	    dataIn = new DataInputStream(con.getInputStream());
	    dataOut = new DataOutputStream(con.getOutputStream());
	    if (dataIn != null)
	    {
	      System.out.println(" data In  OK");
	    } else
	    {
	      connected = false;
	      System.out.println(" dataIn NULL");
	      return connected;
	    }
	    return connected;
	}
	
	private void send(int code)
	  {
	    try
	    {
	      dataOut.writeInt(code);
	      //dataOut.writeBoolean(immediateReturn);
	      dataOut.flush();
	    } catch (IOException e)
	    {
	      System.out.println("send problem " + e);
	    }
	  }
	
	
	  public void forward()
	  {
	    send(RemoteCode.FORWARD);
	  }


	  public void backward()
	  {
	    send(RemoteCode.BACKWARD);
	  }
	  
	  public void left()
	  {
	    send(RemoteCode.LEFT);
	  }


	  public void right()
	  {
	    send(RemoteCode.RIGHT);
	  }
	  
	  public void stop() {
		  send(RemoteCode.STOP);
	  }
	  
	  public void changeState() {
		  send(RemoteCode.BLUETOOTH_STATE);
	  }
	
	  public void exitState() {
		  send(RemoteCode.EXIT_STATE);
	  }
	
	  
	
	
}
