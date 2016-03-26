package hu.schonherz.java.training.jdbc.records;

public class Order {

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
