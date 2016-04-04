package hu.schonherz.homework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.homework.core.dao.Dao;
import hu.schonherz.homework.core.dto.OrderDto;
import hu.schonherz.homework.service.interf.ServiceInterf;
import hu.schonherz.homework.service.mapper.OrderMapper;
import hu.schonherz.homework.service.vo.OrderVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements ServiceInterf<OrderVo>{

	@Autowired
	private Dao<OrderDto> orderDao;
	
	@Override
	public List<OrderVo> getAllVos() {
		return OrderMapper.toVo(orderDao.getAllElements());
	}

	@Override
	public void addVo(OrderVo orderVo) {
		orderDao.addElement(OrderMapper.toDto(orderVo));
	}
}
