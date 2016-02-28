package hu.schonherz.java.training.homwork1.server;

public class Server {
	public enum Status {
		RUNNING, STOPPED, OTHER
	}

	private Integer id;
	private String name;
	private String type;
	private Status status;

	public Server(Integer id, String name, String type, Status status) throws IllegalArgumentException {
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setStatus(status);
	}

	@Override
	public String toString() {
		return "Server [id=" + id + ", name=" + name + ", type=" + type + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Server other = (Server) obj;
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
		if (status != other.status)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) throws IllegalArgumentException {
		// Zero or negative server id is not acceptable
		if (id < 1) {
			throw new IllegalArgumentException("Not positive server ID number");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) throws IllegalArgumentException {
		// You have to give at least 5 letters as a server name
		if (name.length() < 5) {
			throw new IllegalArgumentException("A server name like this doesn't exist");
		}
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) throws IllegalArgumentException {
		// You have to give at least 3 letters as a server type
		if (type.length() < 3) {
			throw new IllegalArgumentException("A server type like this doesn't exist");
		}
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
