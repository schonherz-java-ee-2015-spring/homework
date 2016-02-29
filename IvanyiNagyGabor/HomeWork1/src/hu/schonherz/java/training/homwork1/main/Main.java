package hu.schonherz.java.training.homwork1.main;

import hu.schonherz.java.training.homwork1.thread.StartServer;

public class Main {

	public static void main(String[] args) {

		Thread thread = new Thread(new StartServer());
		thread.start();
	}
}
