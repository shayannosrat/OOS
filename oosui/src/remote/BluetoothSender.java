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
	
	private void send(int code, float param1, float param2)
	  {
	    try
	    {
	      dataOut.writeInt(code);
	      dataOut.writeFloat(param1);
	      dataOut.writeFloat(param2);
	      //dataOut.writeBoolean(immediateReturn);
	      dataOut.flush();
	    } catch (IOException e)
	    {
	      System.out.println("send problem " + e);
	    }
	  }
	
	
	  public void forward()
	  {
	    send(remoteMethod.FORWARD,0,0);
	  }


	  public void backward()
	  {
	    send(remoteMethod.BACKWARD,0,0);
	  }
	  
	  public void left()
	  {
	    send(remoteMethod.LEFT,0,0);
	  }


	  public void right()
	  {
	    send(remoteMethod.RIGHT,0,0);
	  }
	  
	  public void stop() {
		  send(remoteMethod.STOP, 0, 0);
	  }
	
	
	  
	
	
}
