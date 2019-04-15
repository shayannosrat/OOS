package remote;


/**
 *Test of RemotPilotControl.  Be sure RCPilot is running on the NXT before
 * starting this program
 * @author roger
 */
public class RemotPilotTester
{  
    public static void main(String[] args)
    {
    remote pilot = new remote();
    pilot.connect();
    pilot.setTurnSpeed(90);
    pilot.setMoveSpeed(8);
    for(int i = 0 ; i < 6 ; i++)
    {
      pilot.travel(20);
      System.out.println("TRAV 10 "+pilot.getTravelDistance());
      pilot.rotate(-20);
      System.out.println("ROT -90 " + pilot.getAngle());
    }
      pilot.reset();
      pilot.arc(10, 90);
      System.out.println("arc(10,90) distance: " + pilot.getTravelDistance()
              +" angle "+pilot.getAngle());
      pilot.reset();
      pilot.steer(50,-45);
      pilot.steer(-50,45);
      System.out.println("steer " + pilot.getTravelDistance()
              +" angle "+pilot.getAngle());


   System.exit(0);
    }

}