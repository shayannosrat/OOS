package strategy;

import app.Robot;
import constants.RobotState;
import controller.FeedbackController;
import controller.MotorController;
import controller.UltrasonicSensorController;
import controller.WallEColorSensorController;
import controller.WallEMotorController;
import controller.WallEUltrasonicSensorController;
import strategy.Strategy;

/**
 * The main driver class. Controls the robot so that it stays on the line.
 * 
 * @author Till Kobbe, Shayan Nostrat, Nick G�ller, David R�lleke
 *
 */
public class AutonomDriver implements Strategy {
	private final MotorController motor;
	private final WallEColorSensorController colorSensor;
	private final UltrasonicSensorController ultrasonicSensor;

	private final FeedbackController controller;

	private final int state = RobotState.AUTONOM;		

	private final Robot robot;

	/**
	 * default constructor of the autonomous driver. Creates a Motor-, UltrasonicSensor-
	 * and ColorSensorController upon calling
	 * @param r  The robot which should be steered by the autonomous driver
	 * @param con	The feedback controller, which evaluates the color and ultrasonic values and converts them into steering outputs
	 */
	public AutonomDriver(Robot r, FeedbackController con) {
		this.motor = WallEMotorController.getInstance();
		this.colorSensor = WallEColorSensorController.getInstance();
		this.ultrasonicSensor = WallEUltrasonicSensorController.getInstance();
		this.controller = con;
		this.robot = r;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#getState()
	 */
	@Override
	public int getState() {
		return this.state;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see strategy.Strategy#start()
	 */
	@Override
	public void start() {
		System.out.println("Starting Auto");

		motor.setLeftSpeed(MotorController.MAX_SPEED);
		motor.setRightSpeed(MotorController.MAX_SPEED);
		
		int lostCounter = 0;

		while (robot.getState() == this.state) {
			if (this.ultrasonicSensor.readData() <= 20) {
				motor.stop();
				robot.setState(RobotState.STOP);
				break;
			}
			double output;
			int setpoint = colorSensor.getSetpointValue();

			motor.startForward();
			output = controller.getOutput(colorSensor.getLightValue(), setpoint);
			int newSpeed;
			if (output > 1 || output < -1) {
				newSpeed = 0;
			} else {
				newSpeed = (int) ((1 - Math.abs(output)) * MotorController.MAX_SPEED);
			}

			if (output > 0) {
				motor.setLeftSpeed(newSpeed);
				motor.setRightSpeed(MotorController.MAX_SPEED);
			} else {
				motor.setRightSpeed(newSpeed);
				motor.setLeftSpeed(MotorController.MAX_SPEED);
			}
			if(output < (-0.8 * controller.getP()) ) {
				if(lostCounter == 5) {
					robot.setState(RobotState.LINE_LOST);
					break;
				} else {
					lostCounter++;
				}
			} else {
				lostCounter = 0;
			}
		}
		motor.stop();
	}
}
