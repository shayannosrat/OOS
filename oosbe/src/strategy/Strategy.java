package strategy;

/**
 * Interface for the different strategies of the robots
 *
 * @author Till Kobbe, Shayan Nostrat, Nick Göller, David Rölleke
 */
public interface Strategy {

	/**
	 * Starts the strategy
	 */
	void start();

	/**
	 * Returns the state of the strategy
	 * 
	 * @return the state
	 */
	int getState();
}
