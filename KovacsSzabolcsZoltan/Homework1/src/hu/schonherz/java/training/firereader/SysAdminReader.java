package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.SystemAdministrator;

public class SysAdminReader {

	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "sysadmins.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

	public List<SystemAdministrator> reader() {
		List<SystemAdministrator> result = new LinkedList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] attributes = line.split(",");
				List<String> accessList = new LinkedList<>();
				for (int i = 2; i < attributes.length; i++) {
					accessList.add(attributes[i]);
				}
				SystemAdministrator sysadmin = new SystemAdministrator(attributes[0], attributes[1], accessList);
				result.add(sysadmin);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return result;
	}

}
