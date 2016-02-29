package hu.schonherz.java.training.hw.main;

import hu.schonherz.java.training.hw.thread.ReportManager;

public class Main {

	public static void main(String[] args) {
		ReportManager t = new ReportManager(1);
		t.start();
	}

}
