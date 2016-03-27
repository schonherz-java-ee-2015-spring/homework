package hu.schonherz.training.homework4.dto;

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
	private User user;
	private Product product;

	public Order() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
