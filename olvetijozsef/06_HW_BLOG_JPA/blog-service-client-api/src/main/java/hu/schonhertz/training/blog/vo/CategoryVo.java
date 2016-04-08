package hu.schonhertz.training.blog.vo;

import java.io.Serializable;

public class CategoryVo implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	public CategoryVo() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
