package hu.schonherz.java.training.hw.serverservice;

public interface WebContainer {
	/**
	 * Start the WebContainer
	 */
	public void startWebContainer();

	/**
	 * Stop the WebContainer
	 */
	public void stopWebContainer();

	/**
	 * Restart the WebContainer
	 */
	public void restartWebContainer();
}
