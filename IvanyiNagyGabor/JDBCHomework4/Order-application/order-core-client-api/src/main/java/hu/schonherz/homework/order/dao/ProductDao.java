package hu.schonherz.homework.order.dao;

import java.util.List;

import hu.schonherz.homework.order.dto.Product;

public interface ProductDao {

	public List<Product> getAllProducts();

	public Product getProductById(Integer id);
	
	public void addProduct(Product product);
	
	public void addProductsWithBatchSize(Integer batchSize, Product...products);

	public void updateProduct(Product product);

	public void deleteProduct(Product product);
	
	public void deleteProductsWithBatchSize(Integer batchSize, Product...products);
}
