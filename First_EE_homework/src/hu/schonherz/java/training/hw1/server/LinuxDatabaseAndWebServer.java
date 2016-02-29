package hu.schonherz.java.training.hw1.server;

import java.util.ArrayList;
import java.util.LinkedList;

import hu.schonherz.java.training.hw1.serverservice.DatabaseServer;
import hu.schonherz.java.training.hw1.serverservice.WebContainer;

public class LinuxDatabaseAndWebServer extends Server implements WebContainer, DatabaseServer {

	public LinuxDatabaseAndWebServer(int id, String name, Type type, Status status) {
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

	@Override
	public void configure(String params) {
		// TODO Auto-generated method stub

	}

	@Override
	public LinkedList<String> getDeployedApps() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deploy(String app) {
		// TODO Auto-generated method stub
		return false;
	}

}
