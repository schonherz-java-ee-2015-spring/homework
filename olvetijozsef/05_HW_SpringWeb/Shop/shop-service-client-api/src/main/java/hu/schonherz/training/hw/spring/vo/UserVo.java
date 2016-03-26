package hu.schonherz.training.hw.spring.vo;

import java.io.Serializable;

public class UserVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;

	public UserVo() {
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

	@Override
	public String toString() {
		return "UserVo [id=" + id + ", name=" + name + "]";
	}

}
