package hu.schonherz.java.training.hw1.server;

import java.util.ArrayList;

import hu.schonherz.java.training.hw1.serverservice.DatabaseServer;

public class WindowsDatabaseServer extends WindowsServer implements DatabaseServer {

	public WindowsDatabaseServer(int id, String name, Type type, Status status) {
		super( id, name, type, status );
	}
	
	// methods from Server abstract class
	@Override
	public void startServer() {
		System.out.println("The WindowsDatabaseServer has been started!");
	}
		
	@Override
	public void stopServer() {
		System.out.println("The WindowsDatabaseServer has been stopped!");
	}
		
	@Override
	public void restartServer() {
		System.out.println("The WindowsDatabaseServer has been restarted!");
	}
	
	// methods from DatabaseServer
	@Override
	public boolean insert() {
		System.out.println("WindowsDatabaseServer's insert operation is not implemented yet!");
		return false;
	}

	@Override
	public boolean update() {
		System.out.println("WindowsDatabaseServer's update operation is not implemented yet!");
		return false;
	}

	@Override
	public boolean delete(String element) {
		System.out.println("WindowsDatabaseServer's delete operation is not implemented yet!");
		return false;
	}

	@Override
	public ArrayList<String> select(String pattern) {
		System.out.println("WindowsDatabaseServer's select operation is not implemented yet!");
		return null;
	}
}
