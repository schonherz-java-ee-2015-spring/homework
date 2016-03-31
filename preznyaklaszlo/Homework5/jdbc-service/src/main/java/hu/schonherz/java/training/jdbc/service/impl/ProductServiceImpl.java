package hu.schonherz.java.training.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.training.jdbc.core.dao.ProductDao;
import hu.schonherz.java.training.jdbc.service.ProductService;
import hu.schonherz.java.training.jdbc.service.mapper.ProductMapper;
import hu.schonherz.java.training.jdbc.service.vo.ProductVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	@Override
	public List<ProductVo> getAllProducts() {
		return ProductMapper.toVo(productDao.getAllProducts());
	}

	@Override
	public void addProduct(ProductVo productVo) {
		productDao.addProduct(ProductMapper.toDto(productVo));
	}

}
