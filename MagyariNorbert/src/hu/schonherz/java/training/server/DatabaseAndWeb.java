package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;
import sun.security.action.GetLongAction;

public interface DatabaseAndWeb extends Database, WebContainer {
	
	public abstract String getLocation();
	
}
