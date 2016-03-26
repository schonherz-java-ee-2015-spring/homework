package hu.schonherz.training.hw.jdbc.dao;

import java.util.List;

import hu.schonherz.training.hw.jdbc.entity.Product;

public interface ProductDAO {

	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);

	public Product getProductById(int id);

	public List<Product> getAllProducts();

}
