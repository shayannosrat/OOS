package remote;

import java.io.IOException;

import commands.*;

public class BluetoothCtBrick {

	
	public static void main(String[] args) throws IOException
    {
		CommandInvoker invoker = new CommandInvoker();
		invoker.registerBackwardCommand(new BackwardCommand());
		invoker.registerForwardCommand(new ForwardCommand());
		invoker.registerLeftCommand(new LeftCommand());
		invoker.registerRightCommand(new RightCommand());
		invoker.registerStopCommand(new StopCommand());
		
    	BluetoothReceiver btReceiver = new BluetoothReceiver();
    	btReceiver.setInvoker(invoker);
    	btReceiver.go();
    }
	
}
