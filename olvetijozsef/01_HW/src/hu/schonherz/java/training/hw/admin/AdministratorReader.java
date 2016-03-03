package hu.schonherz.java.training.hw.admin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class AdministratorReader {
	private static final String DIRECTORY = "files";
	private static final String FILENAME = "sysadmins.txt";
	private static File file = new File(DIRECTORY + File.separator + FILENAME);

	/**
	 * Read server admins from the inputfile
	 * 
	 * @return list of Administrators
	 */
	public static List<Administrator> read() {
		List<Administrator> admins = new LinkedList<Administrator>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] splittedLine = line.split(",");
				Administrator admin = new Administrator(Integer.parseInt(splittedLine[1]), splittedLine[0]);
				for (int i = 2; i < splittedLine.length; ++i) {
					admin.addRightsForServer(Integer.parseInt(splittedLine[i]));
				}
				admins.add(admin);
			}
		} catch (IOException e) {
			System.out.println("Oops something went wrong! Maybe file not found!");
		}
		return admins;
	}
}
