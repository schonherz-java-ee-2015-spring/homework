package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.pojo.SystemAdministrator;

public class SysAdminReader implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8589682069995451396L;
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "sysadmins.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

	public static List<SystemAdministrator> read() {
		List<SystemAdministrator> lista = new ArrayList<>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				int i = 2;
				String[] parts = line.split(",");
				List<String> tasks = new ArrayList<String>();
				while (i != parts.length) {
					tasks.add(parts[i]);
					i++;
				}

				SystemAdministrator result = new SystemAdministrator(parts[0], Integer.parseInt(parts[1]), tasks);
				lista.add(result);
			}
		} catch (NumberFormatException e) {
			System.out.println("Number Format Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return lista;
	}
}
