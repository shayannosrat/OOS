package strategy;

import constants.RobotState;

public class LineLost implements Strategy {

	private final int state = RobotState.LINE_LOST;
	
	@Override
	public void start() {
		//TODO Line Lost schreiben
	}

	@Override
	public int getState() {
		return this.state;
	}

}
