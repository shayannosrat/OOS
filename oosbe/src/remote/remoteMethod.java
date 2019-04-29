package remote;

/**
 *Defines constants used by RemotePilotControl and RCPilot
 * @author roger
 */
public interface remoteMethod
{
  public final int FORWARD = 0;
  public final int BACKWARD = 1;
  public final int STOP = 2;
  public final int TRAVEL = 3;
  public final int ROTATE = 4;
  public final int STEER = 5;
  public final int ARC = 6;
  public final int RESET = 7;
  public final int SETTRAVELSPEED = 8;
  public final int SETROTATESPEED = 9;
  public final int REPORT = 10;
  public final int LEFT = 11;
  public final int RIGHT = 12;
}
