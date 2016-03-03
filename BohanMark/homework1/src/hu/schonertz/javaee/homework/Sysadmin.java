package hu.schonertz.javaee.homework;

import java.util.List;

public class Sysadmin {
	private int employeeId;
	private String name;
	private List<Integer> servers;
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Integer> getServers() {
		return servers;
	}
	public void setServers(List<Integer> servers) {
		this.servers = servers;
	}
	public Sysadmin(int employeeId, String name, List<Integer> servers) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.servers = servers;
	}
	
}
