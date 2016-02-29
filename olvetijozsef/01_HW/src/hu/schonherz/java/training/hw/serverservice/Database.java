package hu.schonherz.java.training.hw.serverservice;

public interface Database {
	/**
	 * Start the Database Server
	 */
	public void startDatabaseServer();

	/**
	 * Stop the Database Server
	 */
	public void stopDatabaseServer();

	/**
	 * Restart the Database Server
	 */
	public void restartDatabaseServer();

	/**
	 * Tell the URL connection of the Database
	 * 
	 * @return String of URL connection to the Database
	 */
	public String getConnectionURL();
}
