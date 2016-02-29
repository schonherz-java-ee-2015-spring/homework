package hu.schonherz.java.training.hw.server;

public class WindowsServer extends Server {

	/**
	 * Class constructor, create a Windows Server object
	 * 
	 * @param id
	 *            server id
	 * @param name
	 *            server name
	 * @param status
	 *            server current status
	 */
	public WindowsServer(int id, String name, ServerStatus status) {
		super(id, name, status);
	}

}
