package hu.schonherz.java.training.hw1.employee;

import java.util.ArrayList;

public class Sysadmin extends Employee {
	
	// A Sysadmin is an Employee but also has a list of accessed servers
	private ArrayList<Integer> accessedServers;
	
	public Sysadmin( String name, int id, ArrayList<Integer> servers ){
		this.setName(name);
		this.setId(id);
		setAccessedServers(servers);
	}

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

	// Adds a new server id to the accessed servers list
	public void addServer(int serverid) {
		accessedServers.add(serverid);
	}

	// Removes an existing server id from the accessed servers list
	public void removeServer(int which) {
		if (accessedServers.remove(new Integer(which)) != true) {
			System.out.println("Cannot remove server from the list! (404)");
		}
	}
}
