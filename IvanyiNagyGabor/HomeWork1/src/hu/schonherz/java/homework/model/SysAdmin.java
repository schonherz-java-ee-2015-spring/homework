package hu.schonherz.java.homework.model;

import java.util.Set;

public class SysAdmin {

	private String name;
	private Long id;
	private Set<Long> serverIds;

	public SysAdmin(String name, Long id, Set<Long> serverIds) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Long> getServerIds() {
		return serverIds;
	}

	public void setServerIds(Set<Long> serverIds) {
		this.serverIds = serverIds;
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
		SysAdmin other = (SysAdmin) obj;
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

	@Override
	public String toString() {
		return "SysAdmin [name=" + name + ", id=" + id + ", servers=" + serverIds + "]";
	}

}
