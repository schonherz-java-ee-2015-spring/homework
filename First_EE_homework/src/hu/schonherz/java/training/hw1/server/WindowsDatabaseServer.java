package hu.schonherz.java.training.hw1.server;

import java.util.ArrayList;

import hu.schonherz.java.training.hw1.serverservice.DatabaseServer;

public class WindowsDatabaseServer extends Server implements DatabaseServer {

	public WindowsDatabaseServer(int id, String name, Type type, Status status) {
		super();
		this.setId(id);
		this.setName(name);
		this.setType(type);
		this.setStatus(status);
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
