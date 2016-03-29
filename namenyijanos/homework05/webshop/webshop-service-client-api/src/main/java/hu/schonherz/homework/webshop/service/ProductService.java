package hu.schonherz.homework.webshop.service;

import java.util.List;

import hu.schonherz.homework.webshop.vo.ProductVo;

public interface ProductService {

	List<ProductVo> getAllProducts();
	
	void addProduct(ProductVo product);

}
