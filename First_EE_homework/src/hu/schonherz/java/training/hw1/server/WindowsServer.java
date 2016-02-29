package hu.schonherz.java.training.hw1.server;

public class WindowsServer extends Server {
	
	public WindowsServer(int id, String name, Type type, Status status) {
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setStatus(status);
	}
}
