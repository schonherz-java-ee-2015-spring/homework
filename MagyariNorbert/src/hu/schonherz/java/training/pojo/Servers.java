package hu.schonherz.java.training.pojo;

import java.io.Serializable;

public class Servers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7512335621286953251L;
	protected int ID;
	protected String ServerName;
	protected String ServerFunction;
	protected String Status;

	public Servers(int iD, String serverName, String serverFunction, String status) {
		super();
		ID = iD;
		ServerName = serverName;
		ServerFunction = serverFunction;
		Status = status;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getServerName() {
		return ServerName;
	}

	public void setServerName(String serverName) {
		ServerName = serverName;
	}

	public String getServerFunction() {
		return ServerFunction;
	}

	public void setServerFunction(String serverFunction) {
		ServerFunction = serverFunction;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
