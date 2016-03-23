package hu.schonherz.homework.dao;

import java.util.List;

import hu.schonherz.homework.records.Product;

public interface ProductDao {
	
	public List<Product> getAllProducts();
	
	public Product getProduct(String name);
	
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);

}
