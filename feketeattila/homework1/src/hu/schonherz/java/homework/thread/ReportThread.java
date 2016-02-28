package hu.schonherz.java.homework.thread;

import java.util.List;

import hu.schonherz.java.homework.firereader.ServerReader;
import hu.schonherz.java.homework.firereader.SysAdminReader;
import hu.schonherz.java.homework.pojo.Server;
import hu.schonherz.java.homework.pojo.SysAdmin;

public class ReportThread extends Thread {
	@Override
	public void run() {
		while (true) {
			List<Server> servers = ServerReader.read();
			List<SysAdmin> sysAdmins = SysAdminReader.read();
			for (Server server : servers) {
				if (!server.getStatus().equals("RUNNING")) { //If one of the servers is not running...
					System.out.println(server.toString() + " is not running! --- Contact with the administrators :");
					for (SysAdmin sysAdmin : sysAdmins) {
						for (Integer serverId : sysAdmin.getServerIds()) {
							if (serverId == server.getId()) { //...we search for it's system administrator...
								System.out.println("  " + sysAdmin.toString());
							}
						}
					}
				}
			}

			try {
				Thread.sleep(10000); //Sleep for 10 seconds
			} catch (InterruptedException e) {
				System.out.println("Oops, something happened with the thread!");
			}
		}
	}
}
