package hu.schonherz.java.homework.main;

import java.io.File;

import hu.schonherz.java.homework.filemonitor.FileMonitor;

public class Main {

	public static void main(String[] args) {
		String serverFileName = SUBDIRECTORY + File.separator + FILES[0];
		String sysAdminFileName = SUBDIRECTORY + File.separator + FILES[1];

		FileMonitor fileMonitor = new FileMonitor(10000, serverFileName, sysAdminFileName);
		fileMonitor.start();

	}

	private static final String[] FILES = { "servers.txt", "sysadmins.txt" };
	private static final String SUBDIRECTORY = "files";

}
