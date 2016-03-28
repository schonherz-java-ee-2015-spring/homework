package hu.schonherz.homework.order.dto;

import java.io.Serializable;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = 6595764551837906360L;

	private Long userId;
	private Long productId;

	public OrderDto() {
		super();
	}

	public OrderDto(Long userId, Long productId) {
		super();
		this.userId = userId;
		this.productId = productId;
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
		return "OrderDto [userId=" + userId + ", productId=" + productId + "]";
	}

}
