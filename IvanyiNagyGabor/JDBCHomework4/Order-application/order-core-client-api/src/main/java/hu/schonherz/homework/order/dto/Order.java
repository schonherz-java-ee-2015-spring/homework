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

	@Override
	public String toString() {
		return "Order [userId=" + userId + ", productId=" + productId + "]";
	}

	

}
