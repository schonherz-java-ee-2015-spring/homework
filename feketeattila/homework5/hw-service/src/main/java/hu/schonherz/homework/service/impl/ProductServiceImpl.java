package hu.schonherz.homework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.ProductDto;
import hu.schonherz.homework.service.interf.ServiceInterf;
import hu.schonherz.homework.service.mapper.ProductMapper;
import hu.schonherz.homework.service.vo.ProductVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ServiceInterf<ProductVo> {

	@Autowired
	private Dao<ProductDto> productDao;

	@Override
	public List<ProductVo> getAllVos() {
		return ProductMapper.toVo(productDao.getAllElements());
	}

	@Override
	public void addVo(ProductVo productVo) {
		productDao.addElement(ProductMapper.toDto(productVo));
	}

}
