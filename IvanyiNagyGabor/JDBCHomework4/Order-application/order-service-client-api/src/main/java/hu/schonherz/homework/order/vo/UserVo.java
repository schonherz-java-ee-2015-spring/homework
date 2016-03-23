package hu.schonherz.homework.order.vo;

import java.io.Serializable;
import java.util.List;

public class UserVo implements Serializable {
	private static final long serialVersionUID = 5578164806043006547L;

	private Integer id;
	private String name;

	public UserVo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
