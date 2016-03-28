package hu.schonherz.homework.order.dto;

import java.io.Serializable;

public class UserDto implements Serializable {

	private static final long serialVersionUID = -5995816057730310552L;

	private Long id;
	private String name;

	public UserDto() {
		super();
	}

	public UserDto(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
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
		return "UserDto [id=" + id + ", name=" + name + "]";
	}

}
