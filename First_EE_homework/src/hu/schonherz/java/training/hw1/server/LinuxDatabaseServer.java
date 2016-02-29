package hu.schonherz.java.training.hw1.server;

import java.util.ArrayList;

import hu.schonherz.java.training.hw1.serverservice.DatabaseServer;

public class LinuxDatabaseServer extends Server implements DatabaseServer {

	public LinuxDatabaseServer(int id, String name, Type type, Status status) {
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setStatus(status);
	}
	
	@Override
	public void startServer() {
		System.out.println("The LinuxDatabaseServer has been started!");
	}
	
	@Override
	public void stopServer() {
		System.out.println("The LinuxDatabaseServer has been stopped!");
	}
	
	@Override
	public void restartServer() {
		System.out.println("The LinuxDatabaseServer has been restarted!");
	}

	@Override
	public boolean insert() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<String> select(String pattern) {
		// TODO Auto-generated method stub
		return null;
	}

}
