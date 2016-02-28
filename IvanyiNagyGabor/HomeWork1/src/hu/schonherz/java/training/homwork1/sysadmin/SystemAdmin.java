package hu.schonherz.java.training.homwork1.sysadmin;

import java.util.Set;

public class SystemAdmin {

	private String name;
	private Integer id;
	Set<Integer> serverIds;

	public SystemAdmin(String name, Integer id, Set<Integer> serverIds) throws IllegalArgumentException {
		super();
		this.setName(name);
		this.setId(id);
		this.setServerIds(serverIds);
	}

	@Override
	public String toString() {
		return "SystemAdministrator [name=" + name + ", id=" + id + ", serverIds=" + serverIds + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((serverIds == null) ? 0 : serverIds.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemAdmin other = (SystemAdmin) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serverIds == null) {
			if (other.serverIds != null)
				return false;
		} else if (!serverIds.equals(other.serverIds))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		// Regular format: sysadmin + space + at least two letters
		// where sysadmin is not ignore case sensitive
		if (name.toLowerCase().startsWith("sysadmin") && name.length() >= ("sysadmin".length() + 3)) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Not a sysadmin");
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) throws IllegalArgumentException {
		// Zero or negative SysAdmin id is not acceptable
		if (id < 1) {
			throw new IllegalArgumentException("Not positive SysAdmin ID number");
		}
		this.id = id;
	}

	public Set<Integer> getServerIds() {
		return serverIds;
	}

	public void setServerIds(Set<Integer> serverIds) {
		this.serverIds = serverIds;
	}

}
