package hu.schonherz.java.training.jdbc.service;

import java.util.List;

import hu.schonherz.java.training.jdbc.service.vo.ProductVo;

public interface ProductService {

	public List<ProductVo> getAllProducts();

	public void addProduct(ProductVo product);

}
