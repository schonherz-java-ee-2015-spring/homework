package hu.schonherz.java.homework2.behavioral.ai;

/**
 * @author Atka
 *
 */
public interface Ai {
	/**
	 * Commands the AI to look around
	 */
	public void lookCommand();

	/**
	 * Commands the AI to talk
	 */
	public void talkCommand();

	/**
	 * Commands the AI to move
	 */
	public void moveCommand();
}
