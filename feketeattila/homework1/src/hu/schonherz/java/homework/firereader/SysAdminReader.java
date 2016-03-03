package hu.schonherz.java.homework.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.homework.pojo.SysAdmin;

public class SysAdminReader {
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "sysadmins.txt";
	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
	
	public static List<SysAdmin> read() {
		List<SysAdmin> sysAdmins = new LinkedList<SysAdmin>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				List<Integer> serverIds = new LinkedList<Integer>();
				for (int i = 2; i < attributes.length; i++) {
					serverIds.add(Integer.parseInt(attributes[i]));
				}
				sysAdmins.add(new SysAdmin(attributes[0], Integer.parseInt(attributes[1]), serverIds));
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Exception while reading sysadmin-file!");
		}
		return sysAdmins;
	}
}
