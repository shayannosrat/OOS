package strategy;

import app.Robot;
import constants.RobotState;

public class Calibration implements Strategy {
    private final int state = RobotState.CALIBRATION;

    private Robot robot;

    public Calibration(Robot robot) {
        this.robot = robot;
    }

    @Override
    public void start() {
        /*
            Kalibierungen laden und ausführen. Danach state des Robots auf Autonom setzten
         */
    }

    @Override
    public int getState() {
            return this.state;
    }
}
