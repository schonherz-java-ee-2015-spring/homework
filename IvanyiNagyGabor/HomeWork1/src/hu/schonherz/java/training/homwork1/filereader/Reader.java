package hu.schonherz.java.training.homwork1.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import hu.schonherz.java.training.homwork1.server.Server;
import hu.schonherz.java.training.homwork1.server.Server.Status;
import hu.schonherz.java.training.homwork1.sysadmin.SystemAdmin;

public class Reader {

	private static final Reader reader = new Reader();

	private final String FOLDER = "files";
	private final String separator = File.separator;
	private final String SERVERSFILE = "servers.txt";
	private final String SYSADMINSFILE = "sysadmins.txt";

	private List<SystemAdmin> sysAdminList;
	private List<Server> serverList;

	private Readable sysAdminReader;
	private Readable serverReader;

	private Reader() {
		initSysAdminReader();
		initServerReader();
	}

	public static Reader getInstance() {
		return reader;
	}

	@SuppressWarnings("unchecked")
	public void readSysAdmins() {
		sysAdminList = (List<SystemAdmin>) sysAdminReader.readFromFile(new File(FOLDER + separator + SYSADMINSFILE));
		// System.out.println(sysAdminList);
		System.out.println("SystemAdmins:");
		for (SystemAdmin sysadmin : sysAdminList) {
			System.out.println(sysadmin.toString());
		}
		System.out.println("\n");
	}

	@SuppressWarnings("unchecked")
	public void readServers() {
		serverList = (List<Server>) serverReader.readFromFile(new File(FOLDER + File.separator + SERVERSFILE));
		System.out.println(serverList);
		for (Server server : serverList) {
			System.out.println(server.toString());
		}
		System.out.println("\n");

	}

	private void initSysAdminReader() {
		sysAdminReader = (file) -> {
			List<SystemAdmin> sysAdminList = new ArrayList<SystemAdmin>();
			String line;
			String[] array;
			// try-with-resources
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
				while ((line = bufferedReader.readLine()) != null) {
					try {
						array = line.split(",");
						Set<Integer> serverIds = new TreeSet<Integer>();
						for (int i = 2; i < array.length; ++i) {
							serverIds.add(Integer.parseInt(array[i]));
						}
						sysAdminList.add(new SystemAdmin(array[0].trim(), Integer.parseInt(array[1]), serverIds));
					} catch (IllegalArgumentException ex) {
						// The data of this line is not valid
					}
				}
			} catch (FileNotFoundException ex) {
				System.out.println("The file is not found");
			} catch (IOException ex) {
				// Do something
			}
			return sysAdminList;
		};
	}

	private void initServerReader() {
		serverReader = (file) -> {
			List<Server> serverList = new ArrayList<Server>();
			String line;
			String[] array;
			Status status;
			// try-with-resources
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
				while ((line = bufferedReader.readLine()) != null) {
					try {
						array = line.split(",");
						status = this.helpForServerReader(array[3].trim());
						serverList
								.add(new Server(Integer.parseInt(array[0]), array[1].trim(), array[2].trim(), status));
					} catch (IllegalArgumentException ex) {
						// The data of this line is not valid
					}
				}
			} catch (FileNotFoundException ex) {
				System.out.println("The file is not found");
			} catch (IOException ex) {
				// Do something
			}
			return serverList;
		};
	}

	private Status helpForServerReader(String statusName) {
		switch (statusName.toUpperCase()) {
		case "RUNNING":
			return Server.Status.RUNNING;
		case "STOPPED":
			return Server.Status.STOPPED;
		default:
			return Server.Status.OTHER;
		}
	}

}
