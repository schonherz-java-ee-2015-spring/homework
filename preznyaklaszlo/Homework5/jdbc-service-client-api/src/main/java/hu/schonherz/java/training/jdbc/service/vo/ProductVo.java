package hu.schonherz.java.training.jdbc.service.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5302826162945931504L;
	private Integer id;
	private Integer price;
	private String name;

	// public ProductVo(Integer id, Integer price, String name) {
	// super();
	// this.id = id;
	// this.price = price;
	// this.name = name;
	// }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductVo() {
		super();
	}

}
