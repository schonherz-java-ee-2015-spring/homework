package hu.schonherz.java.training.firereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.pojo.Servers;

public class ServerReader {

	private static final String SUBDIRECTORY = "files";
	private static final String FILENAME = "servers.txt";

	private static File file = new File(SUBDIRECTORY + File.separator + FILENAME);

	public static List<Servers> read() {
		List<Servers> lista = new ArrayList<>();

		try (BufferedReader bR = new BufferedReader(new FileReader(file));) {
			String line;
			while ((line = bR.readLine()) != null) {
				String[] parts = line.split(",");
				Servers ser = new Servers(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3]);
				lista.add(ser);
			}
		} catch (IOException e) {
			System.out.println("BufferedReader error -- File not found");
			e.printStackTrace();
		}
		return lista;
	}

}
