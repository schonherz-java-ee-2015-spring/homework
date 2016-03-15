package hu.schonherz.java.training.hw1.serverservice;

import java.util.LinkedList;

public interface WebContainer {
	
	void configure( String params );
	LinkedList<String> getDeployedApps();
	boolean deploy( String app );
	
}
