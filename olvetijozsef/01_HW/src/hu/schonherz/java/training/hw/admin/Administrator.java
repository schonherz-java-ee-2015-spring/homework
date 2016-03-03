package hu.schonherz.java.training.hw.admin;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
	private int id;
	private String name;
	private List<Integer> supportedServers;

	public Administrator(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.supportedServers = new ArrayList<Integer>();
	}

	/**
	 * Add rights for a server
	 * 
	 * @param serverID
	 *            server id
	 * @return
	 */
	public String addRightsForServer(int serverID) {
		if (this.supportedServers.contains(serverID)) {
			return "Already have rights for this server!";
		} else {
			this.supportedServers.add(serverID);
			return "Rights added on!";
		}
	}

	/**
	 * Remove rights for a server
	 * 
	 * @param serverID
	 *            server id
	 * @return
	 */
	public String removeRightsForServer(int serverID) {
		if (this.supportedServers.contains(serverID)) {
			int index = this.supportedServers.indexOf(serverID);
			this.supportedServers.remove(index);
		}
		return "Rights removed!";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getSupportedServers() {
		return supportedServers;
	}

	@Override
	public String toString() {
		return this.name + " - " + this.id + " - " + this.supportedServers;
	}
}
