package hu.schonherz.java.training.hw.server;

import hu.schonherz.java.training.hw.serverservice.Database;

public class WindowsDatabaseServer extends WindowsServer implements Database {
	private String url;

	public WindowsDatabaseServer(int id, String name, String url, ServerStatus status) {
		super(id, name, status);
		this.url = url;
	}

	@Override
	public void startDatabaseServer() {
		this.setStatus(ServerStatus.RUNNING);
	}

	@Override
	public void stopDatabaseServer() {
		this.setStatus(ServerStatus.STOPPED);
	}

	@Override
	public void restartDatabaseServer() {
		if (this.getStatus() == ServerStatus.RUNNING.name()) {
			this.stopDatabaseServer();
		}
		this.startDatabaseServer();
	}

	@Override
	public String getConnectionURL() {
		return this.url;
	}
}
