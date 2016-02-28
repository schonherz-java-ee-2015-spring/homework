package hu.schonherz.java.homework.systemAdministrator;

import java.util.List;

public class SystemAdministrator {
	protected String name;
	protected int adminID;
	protected List<Integer> servers;

	public SystemAdministrator() {
		super();
	}

	public SystemAdministrator(String name, int adminID, List<Integer> servers) {
		super();
		this.name = name;
		this.adminID = adminID;
		this.servers = servers;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public List<Integer> getServers() {
		return servers;
	}

	public void setServers(List<Integer> servers) {
		this.servers = servers;
	}

}
