package hu.schonherz.training.hw.spring.vo;

import java.io.Serializable;

public class OrderVo implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int userId;
	private int productId;

	public OrderVo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		return "OrderVo [id=" + id + ", userId=" + userId + ", productId=" + productId + "]";
	}

}
