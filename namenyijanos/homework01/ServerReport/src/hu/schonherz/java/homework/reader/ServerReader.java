package hu.schonherz.java.homework.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.homework.server.Server;

public class ServerReader {
	
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "servers.txt";
	
	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
	
	public static List<Server> read() {
		List<Server> result = new LinkedList<Server>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				Server server = new Server(Integer.parseInt(attributes[0]), attributes[1], attributes[2], attributes[3]);
				result.add(server);
			}
		} catch (IOException e) {
			System.out.println("File not found");
		}
		return result;
	}

}
