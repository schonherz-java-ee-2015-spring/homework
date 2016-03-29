package hu.schonerz.java.training.hw5.vo;

import java.io.Serializable;

// Plain Value Object
public class UserVo implements Serializable {

	private static final long serialVersionUID = -8713676022894089869L;

	Integer id;
	String name;

	public UserVo() {
		super();
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
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
		return "UserVo [id=" + id + ", name=" + name + "]";
	}

}
