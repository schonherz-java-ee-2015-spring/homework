package hu.schonherz.java.homework1.sysadmin;

import java.util.List;

public class Sysadmin {

	public String sysName;
	public int sysID;
	List<Integer> serverID;

	public String getSysName() {
		return sysName;
	}

	public void setSysName(String sysName) {
		this.sysName = sysName;
	}

	public int getSysID() {
		return sysID;
	}

	public void setSysID(int sysID) {
		this.sysID = sysID;
	}

	public Sysadmin(String sysName, int sysID, List<Integer> serversID) {
		super();
		this.sysName = sysName;
		this.sysID = sysID;
		this.serverID = serversID;
	}

	public List<Integer> getServerID() {
		return serverID;
	}

	public void setServerID(List<Integer> serverID) {
		this.serverID = serverID;
	}

}
