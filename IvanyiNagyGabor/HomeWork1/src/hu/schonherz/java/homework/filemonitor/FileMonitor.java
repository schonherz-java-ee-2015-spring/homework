package hu.schonherz.java.homework.filemonitor;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hu.schonherz.java.homework.model.Server;
import hu.schonherz.java.homework.model.ServerStatus;
import hu.schonherz.java.homework.model.SysAdmin;
import hu.schonherz.java.homework.reader.Reader;
import hu.schonherz.java.homework.reader.ServerReader;
import hu.schonherz.java.homework.reader.SysAdminReader;

public class FileMonitor {

	private Integer period;
	private String serverSource;
	private String sysAdminSource;

	public FileMonitor(Integer period, String serverSource, String sysAdminSource) {
		super();
		this.period = period;
		this.serverSource = serverSource;
		this.sysAdminSource = sysAdminSource;
	}

	public void start() {
		while (true) {
			Reader<Server> serverReader = new ServerReader();
			List<Server> servers = serverReader.read(new File(serverSource));

			Reader<SysAdmin> sysAdminReader = new SysAdminReader();
			List<SysAdmin> sysAdmins = sysAdminReader.read(new File(sysAdminSource));

			println(doPairs(servers, sysAdmins));
			sleep();
		}
	}

	private Map<String, List<String>> doPairs(List<Server> servers, List<SysAdmin> sysAdmins) {

		Map<String, List<String>> pairs = new HashMap<String, List<String>>();

		for (Server server : servers) {
			if (server.getStatus().equals(ServerStatus.STOPPED)) {
				List<String> adminNames = new ArrayList<String>();
				for (SysAdmin sysAdmin : sysAdmins) {
					if (sysAdmin.getServerIds().contains(server.getId())) {
						adminNames.add(sysAdmin.getName());
					}
				}
				pairs.put(server.getName(), adminNames);
			}
		}

		return pairs;
	}

	private void println(Map<String, List<String>> pairs) {
		for (Map.Entry<String, List<String>> entry : pairs.entrySet()) {
			String serverName = entry.getKey();
			System.out.println("Server: " + serverName);

			if (!pairs.get(serverName).isEmpty()) {
				System.out.println("Admin(s):" + pairs.get(serverName));
			}
			System.out.println();
		}
		if (!pairs.isEmpty()) {
			System.out.println("--\t--\t--\t--\t--\t--\t--\n");
		}
	}

	private void sleep() {
		try {
			Thread.sleep(period);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
