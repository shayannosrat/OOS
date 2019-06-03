package app;

import strategy.Strategy;
import strategy.StrategyException;

/**
 * Interface for the Robot - kind of a state machine
 *
 * @author Till Kobbe, Shayan Nostrat, David Rölleke, Nick Göller
 */
public interface Robot {
	/**
	 * Set the current state of the robot to select the matching strategy
	 * @param state The state that the robot should be set in
	 */
	void setState(int state);

	/**
	 * Get the current state of the robot
	 * 
	 * @return The current state
	 */
	int getState();

	/**
	 * Register a new strategy to the robot
	 * 
	 * @param strategy The strategy that should be added
	 * @throws StrategyException if a strategy with the same state is already
	 *                           registered
	 */
	void registerStrategy(Strategy strategy) throws StrategyException;

	/**
	 * Unregister a strategy by looking for the state number of the given Strategy
	 * 
	 * @param strategy The strategy that should be removed
	 * @throws StrategyException if the strategy is not found
	 */
	Strategy unregisterStrategy(Strategy strategy) throws StrategyException;

	/**
	 * Starts the strategies depending on the current state of the robot
	 */
	void startStrategies();
}
