package strategy;

/**
 * Thrown to indicate that something went wrong with the strategies.
 * 
 * @author Till Kobbe
 *
 */
public class StrategyException extends Exception {
	private String msg;

	/**
	 * Constructs an exception with no detail message
	 */
	public StrategyException() {
	}

	/**
	 * Constructs an exception with the given detail message
	 * 
	 * @param msg
	 */
	public StrategyException(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "StrategyException: " + msg;
	}
}
