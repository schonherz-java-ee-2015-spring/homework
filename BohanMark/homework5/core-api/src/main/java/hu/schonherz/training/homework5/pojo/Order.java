package hu.schonherz.training.homework5.pojo;

import java.io.Serializable;

/**
 * The class represents an order
 * 
 * @author Mark Bohan
 *
 */
@SuppressWarnings("javadoc")
public class Order implements Serializable {
	private static final long serialVersionUID = 2861674731589516366L;

	private Integer id;
	private Integer userId;
	private Integer productId;

	public Order() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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



}
