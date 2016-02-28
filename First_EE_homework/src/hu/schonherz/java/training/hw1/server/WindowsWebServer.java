package hu.schonherz.java.training.hw1.server;

import java.util.LinkedList;

import hu.schonherz.java.training.hw1.serverservice.WebContainer;

public class WindowsWebServer extends Server implements WebContainer {

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
