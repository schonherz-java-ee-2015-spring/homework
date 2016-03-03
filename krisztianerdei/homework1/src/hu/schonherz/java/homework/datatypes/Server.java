package hu.schonherz.java.homework.datatypes;



public class Server {

	private int id;
	private String name;
	private String type;
	
	public enum Status {
		RUNNING, STOPPED
	}
	
	Status status;

	public Server(int id, String name, String type, Status status) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.status = status;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
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

}
