package hu.schonherz.java.homework.pojo;

import java.util.List;

public class SysAdmin {
	private String name;
	private int id;
	private List<Integer> serverIds;

	public SysAdmin(String name, int id, List<Integer> serverIds) {
		super();
		this.name = name;
		this.id = id;
		this.serverIds = serverIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Integer> getServerIds() {
		return serverIds;
	}

	public void setServerIds(List<Integer> serverIds) {
		this.serverIds = serverIds;
	}

	@Override
	public String toString() {
		return name + " (" + id + ")";
	}
	
}
