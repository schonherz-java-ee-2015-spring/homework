package hu.schonherz.homework.order.service;

import java.util.List;

import hu.schonherz.homework.order.vo.ProductVo;

public interface ProductService {
	
	public List<ProductVo> getAllProduct() throws Exception;
	
	public void addProduct(ProductVo productVo) throws Exception; 
}
