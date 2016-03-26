package hu.schonherz.training.hw.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.training.hw.spring.dao.ProductDAO;
import hu.schonherz.training.hw.spring.service.ProductService;
import hu.schonherz.training.hw.spring.service.mapper.ProductMapper;
import hu.schonherz.training.hw.spring.vo.ProductVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public void addProduct(ProductVo product) {
		productDAO.addProduct(product.getName(), product.getPrice());
	}

	@Override
	public void updateProduct(ProductVo product) {
		productDAO.updateProduct(ProductMapper.toDto(product));
	}

	@Override
	public void deleteProduct(ProductVo product) {
		productDAO.deleteProduct(product.getId());
	}

	@Override
	public ProductVo getProductById(Integer id) {
		return ProductMapper.toVo(productDAO.getProductById(id));
	}

	@Override
	public List<ProductVo> getAllProducts() {
		return ProductMapper.toVo(productDAO.getAllProducts());
	}

}
