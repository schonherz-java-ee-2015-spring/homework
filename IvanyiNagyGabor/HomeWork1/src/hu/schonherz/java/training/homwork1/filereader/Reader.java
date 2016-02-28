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
import hu.schonherz.java.training.homwork1.sysadmin.SystemAdministrator;

public class Reader {

	private static final Reader reader = new Reader();

	private final String SUBDIRECTORY = "files";
	private final String SERVERSFILENAME = "servers.txt";
	private final String SYSADMINSFILENAME = "sysadmins.txt";

	private List<SystemAdministrator> sysAdminList;
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
		sysAdminList = (List<SystemAdministrator>) sysAdminReader
				.readFromFile(new File(SUBDIRECTORY + File.separator + SYSADMINSFILENAME));
//		System.out.println(sysAdminList);
		System.out.println("SystemAdmins:");
		for (SystemAdministrator sysadmin : sysAdminList) {
			System.out.println(sysadmin.toString());
		}
		System.out.println("\n");
	}

	@SuppressWarnings("unchecked")
	public void readServers() {
		serverList = (List<Server>) serverReader
				.readFromFile(new File(SUBDIRECTORY + File.separator + SERVERSFILENAME));
		System.out.println(serverList);
		for (Server server : serverList) {
			System.out.println(server.toString());
		}
		System.out.println("\n");

	}

	private void initSysAdminReader() {
		this.sysAdminReader = (file) -> {
			List<SystemAdministrator> sysAdminList = new ArrayList<SystemAdministrator>();
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
						sysAdminList.add(new SystemAdministrator(array[0].trim(), Integer.parseInt(array[1]), serverIds));
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
		this.serverReader = (file) -> {
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
						serverList.add(new Server(Integer.parseInt(array[0]), array[1].trim(), array[2].trim(), status));
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
