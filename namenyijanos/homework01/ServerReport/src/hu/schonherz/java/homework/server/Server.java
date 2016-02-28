package hu.schonherz.java.homework.server;

import java.io.Serializable;

public class Server implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1010045523074884154L;
	protected int serverID;
	protected String serverName;
	protected String serverType;
	protected String status;
	
	public Server() {
		super();
	}

	public Server(int parseInt, String string, String string2, String string3) {
		super();
		this.setServerID(parseInt);
		this.setServerName(string);
		this.setServerType(string2);
		this.setStatus(string3);
		
	}

	public int getServerID() {
		return serverID;
	}

	public void setServerID(int serverID) {
		this.serverID = serverID;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


}
