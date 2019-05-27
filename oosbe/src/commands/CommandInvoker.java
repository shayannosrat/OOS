package commands;

/**
 * Class for evaluating the commands
 * 
 * @author dr692175
 *
 */
public class CommandInvoker {
	private Command left, right, forward, backward, stop;

	public void executeNextCommand() {

	}

	/*
	 * Register Methods
	 */

	/**
	 * Set the Command executed, when left is called.
	 * 
	 * @param l Commad to execute
	 */
	public void registerLeftCommand(Command l) {
		this.left = l;
	}

	/**
	 * Set the Command executed, when right is called.
	 * 
	 * @param r Commad to execute
	 */
	public void registerRightCommand(Command r) {
		this.right = r;
	}

	/**
	 * Set the Command executed, when forward is called.
	 * 
	 * @param f Commad to execute
	 */
	public void registerForwardCommand(Command f) {
		this.forward = f;
	}

	/**
	 * Set the Command executed, when backward is called.
	 * 
	 * @param b Commad to execute
	 */
	public void registerBackwardCommand(Command b) {
		this.backward = b;
	}

	/**
	 * Set the Command executed, when stop is called.
	 * 
	 * @param s Commad to execute
	 */
	public void registerStopCommand(Command s) {
		this.stop = s;
	}

	/*
	 * Invoke Methods
	 */

	/**
	 * Execute the left Command.
	 */
	public void left() {
		left.execute();
	}

	/**
	 * Execute the right Command.
	 */
	public void right() {
		right.execute();
	}

	/**
	 * Execute the forward Command.
	 */
	public void forward() {

		forward.execute();
	}

	/**
	 * Execute the backward Command.
	 */
	public void backward() {
		backward.execute();
	}

	/**
	 * Execute the stop Command.
	 */
	public void stop() {
		stop.execute();
	}

}
