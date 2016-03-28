package hu.schonherz.homework.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.homework.order.dao.ProductDao;
import hu.schonherz.homework.order.service.ProductService;
import hu.schonherz.homework.order.service.mapper.ProductMapper;
import hu.schonherz.homework.order.vo.ProductVo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	// Return all product
	@Override
	public List<ProductVo> getAllProduct() throws Exception {
		return ProductMapper.toVo(productDao.findAll());
	}

	// Create a new product
	@Override
	public void addProduct(ProductVo productVo) throws Exception {
		productDao.save(ProductMapper.toDto(productVo));
		
	}

}
