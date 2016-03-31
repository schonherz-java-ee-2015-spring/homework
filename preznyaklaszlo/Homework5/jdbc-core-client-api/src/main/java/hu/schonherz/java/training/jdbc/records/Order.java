package hu.schonherz.java.training.jdbc.records;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7870985913160333422L;
	private Integer userId;
	private Integer productId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public Order(Integer userId, Integer productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

}
