package hu.schonherz.java.training.ServerService;

public interface DatabaseAndWeb extends Database, WebContainer {

	public abstract String getLocation();
	
}