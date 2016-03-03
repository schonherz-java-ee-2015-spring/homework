package hu.schonherz.java.homework.pojo;

public class Server {
	private int id;
	private String name;
	private String type;
	private String status;

	public Server(int id, String name, String type, String status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return id + "-" + name + "-" + type;
	}

}
