package hu.schonherz.java.training.hw1.employee;

import java.util.ArrayList;

public class Sysadmin extends Employee {

	private ArrayList<Integer> accessedServers;

	/**
	 * @return the accessedServers
	 */
	public ArrayList<Integer> getAccessedServers() {
		return accessedServers;
	}

	/**
	 * @param accessedServers
	 *            the accessedServers to set
	 */
	public void setAccessedServers(ArrayList<Integer> accessedServers) {
		this.accessedServers = accessedServers;
	}

	public void addServer(int server) {
		// TODO some formal validation
		accessedServers.add(server);
	}

	public void removeServer(int which) {
		// TODO some formal validation
		if (accessedServers.remove(new Integer(which)) != true) {
			System.out.println("Cannot remove server from the list! (404)");
		}
	}
}
