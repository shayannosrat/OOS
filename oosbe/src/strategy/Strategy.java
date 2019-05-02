package strategy;

/**
 * Interface for the different strategies of the robots
 *
 * @author Till Kobbe
 */
public interface Strategy {

    /**
     * Starts the strategy
     */
    void start();

    int getState();
}
