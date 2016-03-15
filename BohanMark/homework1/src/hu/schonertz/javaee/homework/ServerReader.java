package hu.schonertz.javaee.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ServerReader {
	public static final String FILENAME = "servers.txt";
	public static final String FILELOC = "files";
	public static final String FILEPATH = FILELOC + File.separator + FILENAME;
	public static final String SEPARATOR = ",";

	public ServerReader() {
		super();
	}

	public List<Server> readServers() {
		List<Server> ret = new ArrayList<Server>();

		try(Scanner sc = new Scanner(new FileInputStream(new File(FILEPATH)))) {

			for (; sc.hasNextLine();) {
				String line = sc.nextLine();
				ret.add(lineToServer(line));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return ret;
	}

	public Server lineToServer(String line) {
		Queue<String> serverstrings = (Queue<String>) new LinkedList<String>();

		for (String t : line.split(SEPARATOR))
			serverstrings.add(t);

		Integer id = Integer.parseInt(serverstrings.remove());
		String name = serverstrings.remove();
		String type = serverstrings.remove();
		String status = serverstrings.remove();

		return new Server(id, name, type, status);
	}
}
