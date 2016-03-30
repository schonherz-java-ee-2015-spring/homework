package hu.schonherz.training.homework5.pojo;

import java.io.Serializable;

/**
 * The class represents a product
 * 
 * @author Mark Bohan
 *
 */
@SuppressWarnings("javadoc")
public class Product implements Serializable {
	private static final long serialVersionUID = -2201183879979870580L;

	private Integer id;
	private String name;
	private Integer price;

	public Product() {
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

}
