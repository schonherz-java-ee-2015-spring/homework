package hu.schonherz.java.training.hw.server;

import hu.schonherz.java.training.hw.serverservice.DatabaseAndWeb;

public class LinuxDatabaseAndWebServer extends LinuxServer implements DatabaseAndWeb {
	private String url;

	public LinuxDatabaseAndWebServer(int id, String name, String url, ServerStatus status) {
		super(id, name, status);
		this.url = url;
	}

	@Override
	public void startDWServer() {
		this.setStatus(ServerStatus.RUNNING);
	}

	@Override
	public void stopDWServer() {
		this.setStatus(ServerStatus.STOPPED);
	}

	@Override
	public void restartDWServer() {
		if (this.getStatus() == ServerStatus.RUNNING.name()) {
			this.stopDWServer();
		}
		this.startDWServer();
	}

	@Override
	public String getDatabaseConnectionUrl() {
		return this.url;
	}
}
