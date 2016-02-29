package hu.schonherz.java.training.hw.thread;

import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.hw.admin.Administrator;
import hu.schonherz.java.training.hw.admin.AdministratorReader;
import hu.schonherz.java.training.hw.server.Server;
import hu.schonherz.java.training.hw.server.ServerReader;
import hu.schonherz.java.training.hw.server.ServerStatus;

public class ReportManager extends Thread {

	private static final String RUNNING_SERVERS = "Running Servers:";
	private static final String spacer = "____________________________";
	private int id;

	public ReportManager(int id) {
		super();
		this.id = id;
	}

	@Override
	public void run() {
		while (true) {
			List<Administrator> admins = new LinkedList<Administrator>();
			admins = AdministratorReader.read();
			List<Server> servers = new LinkedList<Server>();
			servers = ServerReader.read();
			System.out.println(RUNNING_SERVERS);
			for (Server server : servers) {
				if (server.getStatus() == ServerStatus.RUNNING.name()) {
					System.out.println(server.getId() + " - " + server.getName());
					for (Administrator admin : admins) {
						if (admin.getSupportedServers().contains(server.getId())) {
							System.out.println("\t" + admin.toString());
						}
					}

				}
			}
			System.out.println(spacer);
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				System.out.println("Oops something went wrong!");
			}
		}
	}

	public int myGetId() {
		return id;
	}
}
