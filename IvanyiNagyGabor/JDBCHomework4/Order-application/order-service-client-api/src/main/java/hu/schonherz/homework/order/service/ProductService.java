package hu.schonherz.homework.order.service;

import java.util.List;

import hu.schonherz.homework.order.vo.ProductVo;

public interface ProductService {
	
	public List<ProductVo> getAllProduct();
	
	public void addProductsWithBatchSize(Integer batchSize, ProductVo... products);
	
	public void deleteProductsWithBatchSize(Integer batchSize, ProductVo...products);
}
