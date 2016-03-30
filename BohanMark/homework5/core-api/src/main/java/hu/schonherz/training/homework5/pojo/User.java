package hu.schonherz.training.homework5.pojo;

import java.io.Serializable;

/**
 * The class represents a user
 * 
 * @author Mark Bohan
 *
 */
@SuppressWarnings("javadoc")
public class User implements Serializable {
	private static final long serialVersionUID = -3192008856436873020L;

	private String name;
	private Integer id;

	public User() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
