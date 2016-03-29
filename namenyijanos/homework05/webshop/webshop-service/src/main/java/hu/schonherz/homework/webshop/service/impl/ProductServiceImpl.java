package hu.schonherz.homework.webshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.schonherz.homework.webshop.dao.ProductDao;
import hu.schonherz.homework.webshop.dto.Product;
import hu.schonherz.homework.webshop.service.ProductService;
import hu.schonherz.homework.webshop.service.mapper.ProductMapper;
import hu.schonherz.homework.webshop.vo.ProductVo;



@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<ProductVo> getAllProducts() {
		List<Product> products = productDao.getAllProducts();
		return ProductMapper.toVo(products);
	}

	@Override
	public void addProduct(ProductVo product) {
		Product p = ProductMapper.toDto(product);
		productDao.addProduct(p);
	}

}
