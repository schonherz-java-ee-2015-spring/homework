package hu.schonherz.java.training.pojo;

import java.util.LinkedList;
import java.util.List;

public class SystemAdministrator {

	private String sysAdminName;
	private String sysAdminID;
	private List<String> accessList = new LinkedList<>();

	public SystemAdministrator(String sysAdminName, String sysAdminID, List<String> accessList) {
		super();
		this.sysAdminName = sysAdminName;
		this.sysAdminID = sysAdminID;
		this.accessList = accessList;
	}

	public String getSysAdminName() {
		return sysAdminName;
	}

	public void setSysAdminName(String sysAdminName) {
		this.sysAdminName = sysAdminName;
	}

	public String getSysAdminID() {
		return sysAdminID;
	}

	public void setSysAdminID(String sysAdminID) {
		this.sysAdminID = sysAdminID;
	}

	public List<String> getAccessList() {
		return accessList;
	}

	public void setAccessList(List<String> accessList) {
		this.accessList = accessList;
	}

	
	
}
