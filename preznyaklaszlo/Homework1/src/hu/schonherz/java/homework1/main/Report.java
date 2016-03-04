package hu.schonherz.java.homework1.main;

import java.util.List;

import hu.schonherz.java.homework1.server.Server;
import hu.schonherz.java.homework1.server.ServerReaderFromFile;
import hu.schonherz.java.homework1.sysadmin.Sysadmin;
import hu.schonherz.java.homework1.sysadmin.SysadminReaderFromFile;

public class Report extends Thread {

	@Override
	public void run() {
		while (true) {

			List<Server> serverList = ServerReaderFromFile.read();
			List<Sysadmin> sysadminList = SysadminReaderFromFile.read();

			for (Server server : serverList) {
				if (server.getServerStatus().equals("STOPPED")) {
					System.out.println(server.getServerName() + " is stopped. Admins: ");
					for (Sysadmin sysadmin : sysadminList) {
						for (Integer serverID : sysadmin.getServerID()) {
							if (serverID == server.getServerID()) {
								System.out.println(sysadmin.getSysName());
							}
						}
					}
				}
			}
			System.out.println("----\t------\t------\t------\t-----\t");

			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
