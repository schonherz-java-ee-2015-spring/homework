package hu.schonherz.java.training.jdbc.service.vo;

import java.io.Serializable;

public class OrderVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5466191119558614417L;

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

	// public OrderVo(Integer userId, Integer productId) {
	// super();
	// this.userId = userId;
	// this.productId = productId;
	// }
	//
	// public OrderVo() {
	// // TODO Auto-generated constructor stub
	// }

}
