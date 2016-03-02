package hu.schonherz.java.training.hw1.serverservice;

import java.util.ArrayList;

public interface DatabaseServer {
	
	boolean insert();
	boolean update();
	boolean delete( String element );
	ArrayList<String> select( String pattern );
	
	default String getConnectionURL(){
		  return "localhost:98765";	  
	}
}
