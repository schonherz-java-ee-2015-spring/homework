package hu.schonherz.java.homework1.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ServerReaderFromFile {

	private static final String SUBDIRECTORY = "files";
	private static final String SERVERS = "servers.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + SERVERS);

	public static List<Server> read() {

		List<Server> servers = new ArrayList<Server>();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				servers.add(new Server(Integer.valueOf(attributes[0]), attributes[1], attributes[2], attributes[3]));

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return servers;
	}

}
