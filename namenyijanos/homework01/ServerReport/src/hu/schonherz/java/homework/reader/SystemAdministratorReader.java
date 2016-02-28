package hu.schonherz.java.homework.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.homework.systemAdministrator.SystemAdministrator;

public class SystemAdministratorReader {
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "sysadmins.txt";
	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
	
	public static List<SystemAdministrator> read() {
		List<SystemAdministrator> result = new LinkedList<SystemAdministrator>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				List<Integer> servers = new LinkedList<Integer>();
				for (int i = 2; i < attributes.length; i++) {
					servers.add(Integer.parseInt(attributes[i]));
				}
				SystemAdministrator sysadmin = new SystemAdministrator(attributes[0], Integer.parseInt(attributes[1]), servers);
				result.add(sysadmin);
			}
		} catch (IOException e) {
			System.out.println("File not found");
		}
		
		return result;
	}
}
