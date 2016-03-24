package hu.schonherz.training.hw.spring.dto;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public User() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
