package constants;

/**
 * Defines the state constants for the Robot
 *
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 */
public abstract class RobotState {

	public static final int BLUETOOTH = 0;
	public static final int AUTONOM = 1;
	public static final int CALIBRATION = 2;
	public static final int EXIT_PROGRAM = 3;
    public static final int LINE_LOST = 5;
	public static final int FIND_LINE = 6;
	public static final int STOP = 7;
}
