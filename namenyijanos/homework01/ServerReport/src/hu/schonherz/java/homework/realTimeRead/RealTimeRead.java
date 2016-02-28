package hu.schonherz.java.homework.realTimeRead;

import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.homework.reader.ServerReader;
import hu.schonherz.java.homework.reader.SystemAdministratorReader;
import hu.schonherz.java.homework.server.Server;
import hu.schonherz.java.homework.systemAdministrator.SystemAdministrator;

public class RealTimeRead extends Thread {

	@Override
	public void run() {
		while (true) {
			List<Server> servers = ServerReader.read();
			List<SystemAdministrator> sysadmins = SystemAdministratorReader.read();
			for (Server server : servers) {
				if (server.getStatus().equals("Stopped") || server.getStatus().equals("stopped")) {
					int id = server.getServerID();
					System.out.print(server.getServerName());
					for (SystemAdministrator sysadmin: sysadmins) {
						List<Integer> serverList = new LinkedList<Integer>();
						serverList = sysadmin.getServers();
						for (int i = 0; i < serverList.size(); i++) {
							if (id == serverList.get(i)) {
								System.out.print(" - ");
								System.out.print(sysadmin.getName());
							}
						}
					}
					System.out.println();
				}
			}

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
