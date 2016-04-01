package hu.schonherz.java.training.jdbc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.training.jdbc.core.dao.OrderDao;
import hu.schonherz.java.training.jdbc.service.OrderService;
import hu.schonherz.java.training.jdbc.service.mapper.OrderMapper;
import hu.schonherz.java.training.jdbc.service.vo.OrderVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	@Override
	public void addOrder(OrderVo orderVo) {
		orderDao.addOrder(OrderMapper.toDto(orderVo));

	}

}
