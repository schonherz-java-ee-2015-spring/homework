package hu.schonherz.java.training.pojo;

import java.util.List;

@SuppressWarnings("unused")
public class ServerClass {

	private String serverName;
	private String serverID;
	private String serverType;
	private String serverStatus;

	public ServerClass(String serverID, String serverName, String serverType, String serverStatus) {
		super();
		this.serverName = serverName;
		this.serverID = serverID;
		this.serverType = serverType;
		this.serverStatus = serverStatus;
	}

	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerID() {
		return serverID;
	}

	public void setServerID(String serverID) {
		this.serverID = serverID;
	}

	public String getServerType() {
		return serverType;
	}

	public void setServerType(String serverType) {
		this.serverType = serverType;
	}

	public String getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}

}
