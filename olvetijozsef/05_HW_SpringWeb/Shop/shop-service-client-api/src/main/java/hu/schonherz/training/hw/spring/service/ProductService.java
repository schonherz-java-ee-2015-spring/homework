package hu.schonherz.training.hw.spring.service;

import java.util.List;

import hu.schonherz.training.hw.spring.vo.ProductVo;

public interface ProductService {

	void addProduct(ProductVo product);

	void updateProduct(ProductVo product);

	void deleteProduct(ProductVo product);

	ProductVo getProductById(Integer id);

	List<ProductVo> getAllProducts();

}
