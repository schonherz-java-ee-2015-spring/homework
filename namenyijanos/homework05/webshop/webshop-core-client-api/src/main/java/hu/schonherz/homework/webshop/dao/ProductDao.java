package hu.schonherz.homework.webshop.dao;

import java.util.List;

import hu.schonherz.homework.webshop.dto.Product;

public interface ProductDao {

	boolean addProduct(Product product);
	
	boolean addProduct(int price, String name);
	
	List<Product> getAllProducts();
}
