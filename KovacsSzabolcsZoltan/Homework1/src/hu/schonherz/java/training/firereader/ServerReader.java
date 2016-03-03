package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.training.pojo.ServerClass;

public class ServerReader {

	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "servers.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

	public List<ServerClass> reader() {

		List<ServerClass> result = new LinkedList<ServerClass>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] attributes = line.split(",");
				if (attributes.length < 4) {
					throw new IndexOutOfBoundsException("The file is corrupted!");
				}
				ServerClass server = new ServerClass(attributes[0], attributes[1], attributes[2], attributes[3]);
				result.add(server);
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
