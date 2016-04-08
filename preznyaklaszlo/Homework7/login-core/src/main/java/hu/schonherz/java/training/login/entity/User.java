package hu.schonherz.java.training.login.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends BaseEntity {

	static enum UserType {
		ADMIN, GUEST, NORMAL
	};

	/**
	 * 
	 */
	private static final long serialVersionUID = 364484357336800111L;

	private String userName;

	public User(String userName, String password, String address, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.userType = userType;
	}

	private String password;

	private String address;

	private String email;

	private UserType userType;

	public User() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserType getUserType() {
		return userType;
	}

}
