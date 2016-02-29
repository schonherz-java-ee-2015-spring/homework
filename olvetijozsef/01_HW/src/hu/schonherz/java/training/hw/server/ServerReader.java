package hu.schonherz.java.training.hw.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class ServerReader {
	private static final String DIRECTORY = "files";
	private static final String FILENAME = "servers.txt";
	private static File file = new File(DIRECTORY + File.separator + FILENAME);

	/**
	 * Read servers from the inputfile
	 * 
	 * @return list of Servers
	 */
	public static List<Server> read() {
		List<Server> servers = new LinkedList<Server>();
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] splittedLine = line.split(",");
				createServerAndAddToList(servers, splittedLine);
			}
		} catch (IOException e) {
			System.out.println("Oops something went wrong! Maybe file not found!");
		}
		return servers;
	}

	/**
	 * Create a server object from a splitted read line. Add the server to the
	 * list.
	 * 
	 * @param servers
	 *            list of the servers
	 * @param splittedLine
	 *            current splitted read line
	 */
	private static void createServerAndAddToList(List<Server> servers, String[] splittedLine) {
		Server server;
		switch (splittedLine[2]) {
		case "Win":
			server = new WindowsServer(Integer.parseInt(splittedLine[0]), splittedLine[1],
					ServerStatus.valueOf(splittedLine[3]));
			servers.add(server);
			break;
		case "Linux":
			server = new LinuxServer(Integer.parseInt(splittedLine[0]), splittedLine[1],
					ServerStatus.valueOf(splittedLine[3]));
			servers.add(server);
			break;
		case "LinuxWeb":
			server = new LinuxWebServer(Integer.parseInt(splittedLine[0]), splittedLine[1],
					ServerStatus.valueOf(splittedLine[3]));
			servers.add(server);
			break;
		case "LinuxDBandWEB":
			server = new LinuxDatabaseAndWebServer(Integer.parseInt(splittedLine[0]), splittedLine[1],
					"localhost:12345", ServerStatus.valueOf(splittedLine[3]));
			servers.add(server);
			break;
		case "WinDB":
			server = new WindowsDatabaseServer(Integer.parseInt(splittedLine[0]), splittedLine[1],
					"localhost:12346", ServerStatus.valueOf(splittedLine[3]));
			servers.add(server);
			break;
		default:
			break;
		}
	}
}
