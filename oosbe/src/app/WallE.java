package app;

import remote.BluetoothReceiver;
import remote.RemoteCodes;
import strategy.Strategy;
import strategy.StrategyException;

import java.util.ArrayList;
import java.util.List;

public class WallE implements Robot {
    private BluetoothReceiver bluetoothReceiver;

    private int state;

    private List<Strategy> strategies = new ArrayList<>();

    public WallE() {
        bluetoothReceiver = BluetoothReceiver.getInstance();

        //Set the default state of the robot to calibrate
        this.state = 2;
    }

    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public int getState() {
        if(bluetoothReceiver.readData() == RemoteCodes.STATE) {
            this.state = 0;
        }
        return this.state;
    }

    @Override
    public void registerStrategy(Strategy strategy) throws StrategyException {
        for(Strategy s : strategies) {
            if(s.getState() == strategy.getState())
                throw new StrategyException("Duplicate State");
        }

        strategies.add(strategy);
    }

    @Override
    public Strategy unregisterStrategy(Strategy strategy) throws StrategyException{
        for(Strategy s : strategies) {
            if(s.getState() == strategy.getState()) {
                strategies.remove(s);
                return s;
            }
        }
        throw new StrategyException("Strategy not found");
    }

    @Override
    public void startStrategys() {
        for(Strategy s : strategies) {
            if(s.getState() == this.state)
                s.start();
        }
    }
}
