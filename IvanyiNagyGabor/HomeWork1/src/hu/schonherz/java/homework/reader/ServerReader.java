package hu.schonherz.java.homework.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.homework.model.Server;
import hu.schonherz.java.homework.model.ServerStatus;

public class ServerReader implements Reader<Server> {

	@Override
	public List<Server> read(File file) {
		List<Server> servers = new ArrayList<Server>();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			Server server;
			while ((line = br.readLine()) != null) {
				server = parseServer(line.split(","));
				if (server != null) {
					servers.add(server);
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("File not found:" + file.getAbsolutePath());
		} catch (IOException e) {
			System.err.println("General I/O exception: " + e.getMessage());
		} catch (Exception e) {
			System.err.println("Unknown exception: " + e.getMessage());
		}
		return servers;
	}

	public Server parseServer(String[] slices) {
		Server server = null;
		try {
			server = new Server(Long.parseLong(slices[0].trim()), slices[1].trim(), slices[2].trim(),
					ServerStatus.valueOf(slices[3].trim()));
		} catch (NumberFormatException e) {
			System.err.println("Cannot convert number: " + slices[0].trim() + "(" + slices[1].trim() + ")");
		} catch (IndexOutOfBoundsException e) {
			System.err.println(
					"IndexOutOfBounds: " + "Server (type and/or status) doesn't exist" + "(" + slices[1].trim() + ")");
		} catch (IllegalArgumentException e) {
			System.err.println("Wrong server status: " + slices[3].trim() + " is not valid status." + "("
					+ slices[1].trim() + ")");
		}
		return server;
	}

}
