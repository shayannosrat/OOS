package remote;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * Test of RemotPilotControl.  Be sure RCPilot is running on the NXT before
 * starting this program
 *
 * @author roger
 */
public class RemotPilotTester {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setSize(600, 600);
        int moveSpeed = 0;

        remote pilot = new remote();
        pilot.connect();
        pilot.setTurnSpeed(90);
        pilot.setMoveSpeed(8);


        f.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {

                switch (Integer.parseInt(e.toString())) {
                    case 87:    //W oben
                        pilot.forward();
                        break;
                    case 65:    //A links
                        pilot.rotate(-20);

                        break;
                    case 83:    //S unten
                        pilot.backward();

                        break;
                    case 68:    //D rechts
                        pilot.rotate(20);
                        break;
                    case 38: //Arrow up
                        pilot.setMoveSpeed(++moveSpeed);
                        break;
                    case 40: //Arrow down
                        pilot.setMoveSpeed(--moveSpeed);
                        break;
                    default:
                        break;
                }
                //System.out.println("Key pressed code=" + e.getKeyCode() + ", char=" + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                pilot.stop();
            }
        });
        /*for (int i = 0; i < 6; i++) {
            pilot.travel(20);
            System.out.println("TRAV 10 " + pilot.getTravelDistance());
            pilot.rotate(-20);
            System.out.println("ROT -90 " + pilot.getAngle());
        }
        pilot.reset();
        pilot.arc(10, 90);
        System.out.println("arc(10,90) distance: " + pilot.getTravelDistance()
                + " angle " + pilot.getAngle());
        pilot.reset();
        pilot.steer(50, -45);
        pilot.steer(-50, 45);
        System.out.println("steer " + pilot.getTravelDistance()
                + " angle " + pilot.getAngle());


        System.exit(0); */
    }

}
