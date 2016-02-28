package hu.schonherz.java.homework.IOhandler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import hu.schonherz.java.homework.datatypes.Server;
import hu.schonherz.java.homework.datatypes.Server.Status;
import hu.schonherz.java.homework.datatypes.Sysadmin;

public class IOHandler {

	public static List<Server> serverRead() {
		String[] args;
		List<Server> result = new LinkedList<>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("files//servers.txt"));
			String line;

			while ((line = br.readLine()) != null) {
				args = line.split(",");
				Status status = Status.valueOf(args[3]);
				result.add(new Server(Integer.parseInt(args[0]), args[1], args[2], status));
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("../homework1/files//servers.txt -- NOT FOUND --");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("IOException");
		}

		return result;
	}

	public static List<Sysadmin> sysadminRead() {
		String[] args;

		List<Sysadmin> result = new LinkedList<Sysadmin>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("files//sysadmins.txt"));
			String line;

			while ((line = br.readLine()) != null) {
				List<Integer> adminOf = new ArrayList<Integer>();
				args = line.split(",");
				if (args.length > 2) {
					for (int i = 2; i < args.length; i++) {

						adminOf.add(Integer.parseInt(args[i]));

					}

					result.add(new Sysadmin(args[0], Integer.parseInt(args[1]), adminOf));

				}
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("../homework1/files//sysadmins.txt -- NOT FOUND --");
		} catch (IOException e) {
			System.out.println("IOException");
		}
		// ;
		// public Sysadmin(String name, int iD, List<Integer> adminof) {

		return result;
	}

}
