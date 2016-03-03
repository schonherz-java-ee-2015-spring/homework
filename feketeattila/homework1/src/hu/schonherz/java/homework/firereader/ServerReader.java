package hu.schonherz.java.homework.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.homework.pojo.Server;

public class ServerReader {
	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "servers.txt";
	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);
	
	public static List<Server> read() {
		List<Server> servers = new LinkedList<Server>();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] attributes = line.split(",");
				servers.add(new Server(Integer.parseInt(attributes[0]),attributes[1],attributes[2],attributes[3]));
			}
			bufferedReader.close();
		} catch (IOException e) {
			System.out.println("Exception while reading server-file!");
		}
		return servers;
	}
}
