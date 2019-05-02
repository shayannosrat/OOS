package strategy;

public class StrategyException extends Exception {
    private String msg;

    public StrategyException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "StrategyException: " + msg;
    }
}
