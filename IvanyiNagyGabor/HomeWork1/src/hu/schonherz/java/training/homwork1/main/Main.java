package hu.schonherz.java.training.homwork1.main;

import hu.schonherz.java.training.homwork1.filereader.Reader;

public class Main {

	public static void main(String[] args) {

		Reader reader = Reader.getInstance();
		reader.readSysAdmins();
		reader.readServers();
		
	}
}
