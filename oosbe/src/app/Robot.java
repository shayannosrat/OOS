package app;

import strategy.Strategy;
import strategy.StrategyException;

/**
 * Interface for the Robot - kind of a state machine
 *
 * @author Till Kobbe
 */
public interface Robot {
    /**
     * Set the current state of the robot to select the matching strategy
     */
    void setState(int state);

    /**
     * Get the current state of the robot
     * @return The current state
     */
    int getState();

    /**
     * Register a new strategy to the robot
     * @param strategy
     * @throws StrategyException if a strategy with the same state is already registered
     */
    void registerStrategy(Strategy strategy) throws StrategyException;

    /**
     * Unregister a Strategy by looking for the state number of the given Strategy
     * @param strategy
     * @throws StrategyException if the strategy is not found
     */
    Strategy unregisterStrategy(Strategy strategy) throws StrategyException;

    /**
     * Starts the strategys depending on the current state of the robot
     */
    void startStrategies();
}
