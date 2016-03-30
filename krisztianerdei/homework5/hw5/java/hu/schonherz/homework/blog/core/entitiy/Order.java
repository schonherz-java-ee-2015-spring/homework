package hu.schonherz.homework.blog.core.entitiy;

import java.io.Serializable;

public class Order implements Serializable {
	// order class with the setters , getters , etc...
	private static final long serialVersionUID = -8970767595261701996L;
	int user_id;
	int product_id;

	public Order(int user_id, int product_id) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", product_id=" + product_id + "]";
	}

}
