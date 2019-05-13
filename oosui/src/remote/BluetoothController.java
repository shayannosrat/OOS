package remote;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 *Test of RemotPilotControl.  Be sure RCPilot is running on the NXT before
 * starting this program
 * @author roger
 */
public class BluetoothController
{  
	
	
	
    public static void main(String[] args)
    {
    	 String name = "Wall-E";
    	 String address = "00:16:53:1B:C5:4F";
    	 
    	 BluetoothSender btSender = new BluetoothSender();
    	 btSender.connect(name, address);
    	 
    	 
    	 JFrame f = new JFrame();
         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         f.setVisible(true);
         f.setSize(600, 600);

         f.addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {
             }

             @Override
             public void keyPressed(KeyEvent e) {

                 switch (e.getKeyCode()) {
                     case 87:    //W oben
                        btSender.forward();
                         break;
                     case 65:    //A links
                    	 btSender.left();
                         break;
                     case 83:    //S unten
                    	 btSender.backward();
                         break;
                     case 68:    //D rechts
                    	 btSender.right();
                         break;
                     case 32: //state ändern SPACE
                    	 btSender.changeState();
                    	 break;
                     case 16: //state exit RIGHTSHIFT
                    	 btSender.exitState();
                    	 break;
                    
                   
                     default:
                         break;
                 }
             }

             @Override
             public void keyReleased(KeyEvent e) {
            	// btSender.stop();
             }
 });
    	 
    	 

    	 
    }

}
