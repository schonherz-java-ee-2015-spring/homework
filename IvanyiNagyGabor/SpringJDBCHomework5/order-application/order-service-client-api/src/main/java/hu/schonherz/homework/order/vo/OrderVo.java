package hu.schonherz.homework.order.vo;

import java.io.Serializable;

public class OrderVo implements Serializable {

	private static final long serialVersionUID = -526218723245855528L;
	private Long userId;
	private Long productId;

	public OrderVo() {
		super();
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the productId
	 */
	public Long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(Long productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "OrderVo [userId=" + userId + ", productId=" + productId + "]";
	}

}
