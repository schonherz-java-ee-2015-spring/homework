package hu.schonherz.homework.webshop.vo;

import java.io.Serializable;

public class OrderVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2929316837868922794L;

	int userId;
	int productId;
	
	public OrderVo() {
		super();
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
		return "OrderVO [User ID: " + userId + ", Product ID: " + productId + "].";
	}
}
