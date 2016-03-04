package hu.schonherz.java.training.hw1.server;

import java.util.LinkedList;

import hu.schonherz.java.training.hw1.serverservice.WebContainer;

public class WindowsWebServer extends WindowsServer implements WebContainer {

	public WindowsWebServer(int id, String name, Type type, Status status) {
		super( id, name, type, status );
	}
	// methods from Server abstract class
	@Override
	public void startServer() {
		System.out.println("The WindowsWebServer has been started!");
	}

	@Override
	public void stopServer() {
		System.out.println("The WindowsWebServer has been stopped!");
	}
	
	@Override
	public void restartServer() {
		System.out.println("The WindowsWebServer has been restarted!");
	}
	
	// methods from WebContainer interface
	@Override
	public void configure(String params) {
		System.out.println("WindowsWebServer's configure operation is not implemented yet!");
		
	}

	@Override
	public LinkedList<String> getDeployedApps() {
		System.out.println("WindowsWebServer's getDeployedApps operation is not implemented yet!");
		return null;
	}

	@Override
	public boolean deploy(String app) {
		System.out.println("WindowsWebServer's deploy operation is not implemented yet!");
		return false;
	}
}
