package hu.schonherz.java.training.hw.thread;

import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.hw.admin.Administrator;
import hu.schonherz.java.training.hw.admin.AdministratorReader;
import hu.schonherz.java.training.hw.server.Server;
import hu.schonherz.java.training.hw.server.ServerReader;
import hu.schonherz.java.training.hw.server.ServerStatus;

public class ReportManager extends Thread {
	private static final String STOPPED_SERVERS = "Stopped Servers:";
	private int id;

	public ReportManager(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		while (true) {
			List<Server> servers = new LinkedList<Server>();
			List<Administrator> admins = new LinkedList<Administrator>();
			servers = ServerReader.read();
			admins = AdministratorReader.read();
			printStoppedServersWithAdmins(servers, admins);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Oops something went wrong!");
			}
		}
	}

	private void printStoppedServersWithAdmins(List<Server> servers, List<Administrator> admins) {
		System.out.println(STOPPED_SERVERS);
		for (Server server : servers) {
			if (server.getStatus() == ServerStatus.STOPPED.name()) {
				System.out.println(server.getId() + " - " + server.getName());
				for (Administrator admin : admins) {
					if (admin.getSupportedServers().contains(server.getId())) {
						System.out.println("\t" + admin.getName().toString());
					}
				}
			}
		}
		System.out.println("\n");
	}

	public int getMyId() {
		return id;
	}
}
