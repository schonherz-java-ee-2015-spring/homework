package hu.schonherz.java.training.hw.server;

import hu.schonherz.java.training.hw.serverservice.WebContainer;

public class LinuxWebServer extends LinuxServer implements WebContainer {
	public LinuxWebServer(int id, String name, ServerStatus status) {
		super(id, name, status);
	}

	@Override
	public void startWebContainer() {
		this.setStatus(ServerStatus.RUNNING);
	}

	@Override
	public void stopWebContainer() {
		this.setStatus(ServerStatus.STOPPED);
	}

	@Override
	public void restartWebContainer() {
		if (this.getStatus() == ServerStatus.RUNNING.name()) {
			this.stopWebContainer();
		}
		this.startWebContainer();
	}
}
