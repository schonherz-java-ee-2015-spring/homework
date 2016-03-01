package hu.schonherz.java.training.hw.server;

public class Server {
	private int id;
	private String name;
	private ServerStatus status;

	public Server(int id, String name, ServerStatus status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public String getStatus() {
		return this.status.name();
	}

	public void setStatus(ServerStatus status) {
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

	@Override
	public String toString() {
		return this.id + " - " + this.name + " - " + this.getClass().getSimpleName() + " - " + this.status;
	}
}
