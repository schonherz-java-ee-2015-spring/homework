package hu.schonherz.java.training.jdbc.service;

import java.util.List;

import hu.schonherz.java.training.jdbc.vo.ProductVo;

public interface ProductService {

	public ProductVo getProductByName(String name);

	public List<ProductVo> getAllProducts();

	public void addProduct(ProductVo product);

	public void updateProduct(ProductVo product);

	public void deleteProduct(ProductVo product);
}
