package hu.schonherz.homework.order.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {
	private static final long serialVersionUID = 747298077526601951L;

	private Integer id;
	private String name;
	private Integer price;


	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVo [id=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
