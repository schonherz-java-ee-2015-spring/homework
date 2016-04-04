package hu.schonhertz.training.blog.vo;

import java.io.Serializable;

public class UserNameVo implements Serializable {

	private static final long serialVersionUID = 5932000328505763772L;

	private Long id;
	private String userName;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
