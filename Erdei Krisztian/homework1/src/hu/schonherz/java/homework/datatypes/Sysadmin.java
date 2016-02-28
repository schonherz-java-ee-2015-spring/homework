package hu.schonherz.java.homework.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Sysadmin {
	private String name;
	private int ID;
	List<Integer> adminOf = new ArrayList<Integer>();

	public Sysadmin(String name, int iD, List<Integer> adminof) {
		super();
		this.name = name;
		ID = iD;
		this.adminOf = adminof;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public List<Integer> getAdminof() {
		return adminOf;
	}

	public void setAdminof(List<Integer> adminof) {
		this.adminOf = adminof;
	}

}
