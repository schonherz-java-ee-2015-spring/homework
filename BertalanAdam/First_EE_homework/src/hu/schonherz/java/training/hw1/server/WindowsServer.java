package hu.schonherz.java.training.hw1.server;

public class WindowsServer extends Server {
	
	public WindowsServer(int id, String name, Type type, Status status) {
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setStatus(status);
	}
	
	// methods from Server abstract class
	@Override
	public void startServer() {
		System.out.println("The WindowsServer has been started!");
	}
	
	@Override
	public void stopServer() {
		System.out.println("The WindowsServer has been stopped!");
	}
	
	@Override
	public void restartServer() {
		System.out.println("The WindowsServer has been restarted!");
	}
}
