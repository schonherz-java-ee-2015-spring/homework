package hu.schonherz.homework.order.vo;

import java.io.Serializable;

public class OrderVo implements Serializable {
	private static final long serialVersionUID = -376170873247979945L;

	private Integer userId;
	private Integer productId;

	public OrderVo() {
		super();
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
		return "OrderVo [userId=" + userId + ", productId=" + productId + "]";
	}

}
