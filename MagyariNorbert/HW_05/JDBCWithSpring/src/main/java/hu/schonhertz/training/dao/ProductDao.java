package hu.schonhertz.training.dao;

import java.util.List;

import hu.schonhertz.training.pojo.Product;

public interface ProductDao {

	public List<Product> getAllProduct();

	public Product getProductById(Long id);

	public void createProduct(String name, Integer price, Long id);

	public void deleteProduct(String name);
}
