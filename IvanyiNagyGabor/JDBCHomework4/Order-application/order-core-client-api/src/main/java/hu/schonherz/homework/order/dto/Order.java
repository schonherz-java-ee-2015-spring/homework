package hu.schonherz.homework.order.dto;

public class Order {

	private Integer userId;
	private Integer productId;

	public Order() {
		super();
	}

	public Order(Integer userId, Integer productId) {
		super();
		this.userId = userId;
		this.productId = productId;
	}

	/**
	 * @return the userId
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", productId=" + productId + "]";
	}

}
