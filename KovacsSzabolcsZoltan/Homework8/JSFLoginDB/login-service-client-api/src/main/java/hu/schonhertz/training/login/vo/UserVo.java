package hu.schonhertz.training.login.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

	private static final long serialVersionUID = 5932000328505763772L;
	
	private String userName;
	private String password;
	private String emailAddress;
	private String userType;
	
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
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", password=" + password + ", emailAddress=" + emailAddress
				+ ", userType=" + userType + "]";
	}
		
	

}
