package hu.schonherz.java.training.hw.serverservice;

public interface DatabaseAndWeb {
	/**
	 * Start the Database Server and WebContainer
	 */
	public void startDWServer();

	/**
	 * Stop the Database Server and WebContainer
	 */
	public void stopDWServer();

	/**
	 * Restart the Database Server and WebContainer
	 */
	public void restartDWServer();

	/**
	 * Tell the URL connection of the Database
	 * 
	 * @return String of URL connection to the Database
	 */
	public String getDatabaseConnectionUrl();
}
