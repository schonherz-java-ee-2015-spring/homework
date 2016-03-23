package hu.schonherz.homework.order.vo;

import java.io.Serializable;

public class ProductVo implements Serializable {
	private static final long serialVersionUID = 747298077526601951L;

	private Integer id;
	private String name;
	private Integer price;
	
	

	public ProductVo(Integer id, String name, Integer price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public ProductVo() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductVo [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	

}
