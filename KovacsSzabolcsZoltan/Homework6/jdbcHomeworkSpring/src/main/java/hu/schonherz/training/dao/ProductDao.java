package hu.schonherz.training.dao;

import java.util.List;

import hu.schonherz.training.pojo.Product;

public interface ProductDao {

	public List<Product> getAllProduct();

	public Product getProductById(int id);

	public void createProduct(String name, int price);
	
	public void removeProduct(String name);
}
