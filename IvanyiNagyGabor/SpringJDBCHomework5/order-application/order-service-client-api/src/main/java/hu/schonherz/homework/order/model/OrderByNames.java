package hu.schonherz.homework.order.model;

import java.io.Serializable;

public class OrderByNames implements Serializable {

	private static final long serialVersionUID = 5596886964715171349L;

	private String userName;
	private String productName;

	/**
	 * @param userName
	 * @param productName
	 */
	public OrderByNames(String userName, String productName) {
		super();
		this.userName = userName;
		this.productName = productName;
	}

	/**
	 * 
	 */
	public OrderByNames() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

}
