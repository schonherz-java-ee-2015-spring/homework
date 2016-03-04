package hu.schonherz.java.homework1.server;

public class Server {

	public int serverID;
	public String serverName, serverType, serverStatus;

	public Server(int ID, String name, String type, String status) {
		this.serverID = ID;
		this.serverName = name;
		this.serverType = type;
		this.serverStatus = status;
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

	public String getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(String serverStatus) {
		this.serverStatus = serverStatus;
	}
}
