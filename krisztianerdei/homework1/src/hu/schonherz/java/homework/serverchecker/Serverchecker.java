package hu.schonherz.java.homework.serverchecker;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.homework.IOhandler.IOHandler;
import hu.schonherz.java.homework.datatypes.Server;
import hu.schonherz.java.homework.datatypes.Sysadmin;
import hu.schonherz.java.homework.datatypes.Server.Status;

public class Serverchecker extends Thread {

	@Override
	public void run() {

		while (true) {
			
			List<Integer> Sid = new ArrayList<>(); // Stopped server ids
			List<Server> servers = new ArrayList<>();
			servers = IOHandler.serverRead();

			List<Sysadmin> sysadmins = new ArrayList<Sysadmin>();
			sysadmins = IOHandler.sysadminRead();

			for (Server server : servers) {
				if (server.getStatus() == Status.STOPPED) {
					Sid.add(server.getId());
				}
			}
			

			if (Sid.size() > 0)
				for (Server server1 : servers) {
					for (int j = 0; j < Sid.size(); j++) {
						if (server1.getId() == Sid.get(j)) {
							System.out.print(server1.getName() + " ");
							for (Sysadmin sysadmin : sysadmins) {
								if (sysadmin.getAdminof().contains(server1.getId())) {
									System.out.print(sysadmin.getName() + " ");
								}
							}
							System.out.println();

						}
					}
				}
			System.out.println(" ");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			super.run();
		}
	}
}
