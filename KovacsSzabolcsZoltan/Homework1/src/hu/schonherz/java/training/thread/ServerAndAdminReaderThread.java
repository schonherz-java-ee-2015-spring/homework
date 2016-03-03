package hu.schonherz.java.training.thread;

import java.util.List;

import hu.schonherz.java.training.firereader.ServerReader;
import hu.schonherz.java.training.firereader.SysAdminReader;
import hu.schonherz.java.training.pojo.ServerClass;
import hu.schonherz.java.training.pojo.SystemAdministrator;

public class ServerAndAdminReaderThread extends Thread {

	@Override
	public void run() {

		while (true) {
			List<ServerClass> servers = new ServerReader().reader();
			List<SystemAdministrator> sysadmins = new SysAdminReader().reader();
			StringBuilder sb = new StringBuilder();
			for (ServerClass server : servers) {
				if (server.getServerStatus().equals("STOPPED")) {
					sb.append(server.getServerName());
					for (SystemAdministrator sysadmin : sysadmins) {
						List<String> accessList = sysadmin.getAccessList();
						for (int i = 0; i < accessList.size(); i++) {
							if (accessList.contains(server.getServerID())) {
								sb.append(" - ").append(sysadmin.getSysAdminName());
								break;
							}
						}
					}
					sb.append("\n");
				}
			}
			System.out.println(sb.toString());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
