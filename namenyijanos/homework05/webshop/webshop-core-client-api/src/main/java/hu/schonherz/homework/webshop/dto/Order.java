package hu.schonherz.homework.webshop.dto;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8750114816564333117L;
	private int userId;
	private int productId;


	public Order() {
		super();
	}
	
	public Order(int userId, int productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Order [User ID: " + userId + ", Product ID: " + productId + "].";
	}
	
}

