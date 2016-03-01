package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;
import hu.schonherz.java.training.ServerService.WebContainer;

public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {

	public enum Status {RUNNING, DATABASESTOPPEP, WEBCONTAINERSTOPPEP};
	
	private Status status;
	
	
	
	public LinuxDatabaseAndWebServer(Status status) {
		super();
		this.status = status;
	}

	@Override
	public void startWebContainer() {
		System.out.println("Web container is starting...");
	}

	@Override
	public void stopWebContainer() {
		System.out.println("Web container is stopping...");

	}

	@Override
	public void restartWebContainer() {
		if(status == Status.RUNNING){
			stopWebContainer();
		}
		startWebContainer();
	}
	

	@Override
	public String getStatus() {
		return status.name();
	}

	@Override
	public String getConnectionURL() {
		return "localhost:54321";
	}



//public class LinuxDatabaseAndWebServer extends LinuxServer implements Database, WebContainer {
//  
//  public enum Status {RUNNING, DATABASESTOPPED, WEBCONTAINERSTOPPER}
//  
//  private Status status;
//
//  public LinuxDatabaseAndWebServer(Status status) {
//    super();
//    this.status = status;
//  }
//
//  @Override
//  public void startWebContainer() {
//    System.out.println("Web container is starting");
//  }
//
//  @Override
//  public void stopWebContainer() {
//    System.out.println("Web container is stopping");
//  }
//
//  @Override
//  public void restartWebContainer() {
//    if(status == Status.RUNNING) {
//      stopWebContainer();
//    }
//    startWebContainer();
//  }
//
//  @Override
//  public String getStatus() {
//    return status.name();
//  }
//
//  @Override
//  public String getConnectionURL() {
//    return "localhost:54321";
//  }
//>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd

}
