package hu.schonherz.java.training.hw1.server;

import java.util.ArrayList;
import java.util.LinkedList;

import hu.schonherz.java.training.hw1.serverservice.DatabaseServer;
import hu.schonherz.java.training.hw1.serverservice.WebContainer;

public class LinuxDatabaseAndWebServer extends LinuxServer implements WebContainer, DatabaseServer {

	public LinuxDatabaseAndWebServer(int id, String name, Type type, Status status) {
		super( id, name, type, status );
	}
	
	// methods from Server abstract class
	@Override
	public void startServer() {
		System.out.println("The LinuxDatabaseAndWebServer has been started!");
	}
	
	@Override
	public void stopServer() {
		System.out.println("The LinuxDatabaseAndWebServer has been stopped!");
	}
	
	@Override
	public void restartServer() {
		System.out.println("The LinuxDatabaseAndWebServer has been restarted!");
	}
	
	// methods from DatabaseServer interface
	@Override
	public boolean insert() {
		System.out.println("LinuxDatabaseAndWebServer's insert operation is not implemented yet!");
		return false;
	}

	@Override
	public boolean update() {
		System.out.println("LinuxDatabaseAndWebServer's update operation is not implemented yet!");
		return false;
	}

	@Override
	public boolean delete(String element) {
		System.out.println("LinuxDatabaseAndWebServer's delete operation is not implemented yet!");
		return false;
	}

	@Override
	public ArrayList<String> select(String pattern) {
		System.out.println("LinuxDatabaseAndWebServer's select operation is not implemented yet!");
		return null;
	}
	
	// methods from WebContainer interface
	@Override
	public void configure(String params) {
		System.out.println("LinuxDatabaseAndWebServer's configure operation is not implemented yet!");

	}

	@Override
	public LinkedList<String> getDeployedApps() {
		System.out.println("LinuxDatabaseAndWebServer's getDeployedApps operation is not implemented yet!");
		return null;
	}

	@Override
	public boolean deploy(String app) {
		System.out.println("LinuxDatabaseAndWebServer's deploy operation is not implemented yet!");
		return false;
	}

}
