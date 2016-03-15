package hu.schonherz.java.homework1.sysadmin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SysadminReaderFromFile {

	private static final String SUBDIRECTORY = "files";
	private static final String SYSADMINS = "sysadmins.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + SYSADMINS);

	public static List<Sysadmin> read() {

		List<Sysadmin> sysadmins = new ArrayList<Sysadmin>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				List<Integer> ids = new ArrayList<Integer>();
				for (int i = 2; i < attributes.length; i++) {
					ids.add(Integer.parseInt(attributes[i]));
				}
				sysadmins.add(new Sysadmin(attributes[0], Integer.parseInt(attributes[1]), ids));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sysadmins;
	}
}
