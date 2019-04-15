package oosui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import lejos.pc.comm.NXTComm;
import lejos.pc.comm.NXTCommException;
import lejos.pc.comm.NXTCommFactory;

public class UI {
	
	 public static void main(String[] args) {
		 NXTComm nxtComm;
		 	try {
		 		nxtComm = NXTCommFactory.createNXTComm(NXTCommFactory.USB);
			 	nxtComm.search(null);
			} catch (NXTCommException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	        // TODO Auto-generated method stub
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
	                System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
	            }

	            @Override
	            public void keyReleased(KeyEvent e) {
	            }
	        });
	    }
}
