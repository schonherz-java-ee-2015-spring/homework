package hu.schonherz.java.training.hw1.server;

import java.util.ArrayList;
import java.util.LinkedList;

import hu.schonherz.java.training.hw1.serverservice.DatabaseServer;
import hu.schonherz.java.training.hw1.serverservice.WebContainer;

public class WindowsDatabaseAndWebServer extends WindowsServer implements DatabaseServer, WebContainer {

	public WindowsDatabaseAndWebServer(int id, String name, Type type, Status status) {
		super( id, name, type, status );
	}
	
	// methods from Server abstract class
	@Override
	public void startServer() {
		System.out.println("The WindowsDatabaseAndWebServer has been started!");
	}
	
	@Override
	public void stopServer() {
		System.out.println("The WindowsDatabaseAndWebServer has been stopped!");
	}
	
	@Override
	public void restartServer() {
		System.out.println("The WindowsDatabaseAndWebServer has been restarted!");
	}
	
	// methods from WebContainer interface
	@Override
	public void configure(String params) {
		System.out.println("WindowsDatabaseAndWebServer's configure operation is not implemented yet!");

	}

	@Override
	public LinkedList<String> getDeployedApps() {
		System.out.println("WindowsDatabaseAndWebServer's getDeployedApps operation is not implemented yet!");
		return null;
	}

	@Override
	public boolean deploy(String app) {
		System.out.println("WindowsDatabaseAndWebServer's deploy operation is not implemented yet!");
		return false;
	}

	// methods from DatabaseServer interface
	@Override
	public boolean insert() {
		System.out.println("WindowsDatabaseAndWebServer's insert operation is not implemented yet!");
		return false;
	}

	@Override
	public boolean update() {
		System.out.println("WindowsDatabaseAndWebServer's update operation is not implemented yet!");
		return false;
	}

	@Override
	public boolean delete(String element) {
		System.out.println("WindowsDatabaseAndWebServer's delete operation is not implemented yet!");
		return false;
	}

	@Override
	public ArrayList<String> select(String pattern) {
		System.out.println("WindowsDatabaseAndWebServer's select operation is not implemented yet!");
		return null;
	}
}
