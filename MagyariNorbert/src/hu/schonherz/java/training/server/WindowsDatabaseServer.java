package hu.schonherz.java.training.server;

import hu.schonherz.java.training.ServerService.Database;

public class WindowsDatabaseServer extends WindowsServer implements Database {

	private Status status;

	public WindowsDatabaseServer(Status status) {
		super();
		this.status = status;
	}

	@Override
	public String getStatus() {
		return status.name();
	}

	@Override
	public String getConnectionURL() {
		return "localhost:123";
	}


//public class WindowsDatabaseServer extends WindowsServer implements Database {
//  
//  private Status status;
//
//  public WindowsDatabaseServer(Status status) {
//    super();
//    this.status = status;
//  }
//
//  @Override
//  public String getStatus() {
//    return status.toString();
//  }
//  /*
//  // default method has been implemented
//  @Override
//  public String getConnectionURL() {
//    return "localhost:12345";
//  }*/
//>>>>>>> c4bc2faea37cc837a00763b91c277400d53113fd

}
