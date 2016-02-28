package hu.schonherz.java.homework.main;

import hu.schonherz.java.homework.thread.ReportThread;

public class Main {
	public static void main(String[] args) {
		homework();
	}

	/*
	 * As a manager of the company, I want a real-time report for those servers,
	 * which are not running. The report should tell that which system
	 * administrators have right for those servers.
	 * 
	 * ---------------------
	 * real-time : continuously while the program is running (10 second intervals)
	 * report : write out on console
	 * format : name of the server, list of the administrators (name)
	 * TEST : if the servers.txt has been changed, it will be presented in the report
	 * 
	 * servers.txt:
	 * 1) server's ID
	 * 2) server's name
	 * 3) server's type
	 * 4) server's status (RUNNING, STOPPED)
	 * 
	 * sysadmins.txt:
	 * 1) system administrator's name
	 * 2) system administrator's employee ID
	 * 3...) ID of the servers he/she has right to
	 */
	private static void homework() {
		ReportThread reportThread = new ReportThread();
		reportThread.run();
	}
}
