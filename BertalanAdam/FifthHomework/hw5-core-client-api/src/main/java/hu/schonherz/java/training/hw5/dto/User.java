package hu.schonherz.java.training.hw5.dto;

import java.io.Serializable;

/**
 * Plain Data Transfer Object for carrying user data.
 * */
public class User implements Serializable {

	private static final long serialVersionUID = -1082628511680781467L;
	
	private int id;
	private String name;

	public User(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public User() {
		super();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}

}
