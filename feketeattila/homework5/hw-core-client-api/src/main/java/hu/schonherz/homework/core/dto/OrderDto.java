package hu.schonherz.homework.core.dto;

import java.io.Serializable;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = -4584049086733486312L;
	
	private Long productId;
	private Long userId;

	public OrderDto() {
		super();
	}
	
	public OrderDto(Long productId, Long userId) {
		super();
		this.productId = productId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [productId=" + productId + ", userId=" + userId + "]";
	}

}
