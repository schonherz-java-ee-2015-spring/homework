package hu.schonherz.homework.headswitcher.user;

import java.io.Serializable;

public class User implements Serializable{
	
	@Override
	public String toString() {
		return "User [id=" + id + ", Name=" + Name + "]";
	}
	private static final long serialVersionUID = -1561832904001222814L;
	int id;
	String Name;
	public User(int id, String name) {
		super();
		this.id = id;
		Name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	
	

}
