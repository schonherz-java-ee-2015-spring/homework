package hu.schonherz.homework.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.homework.order.dao.OrderDao;
import hu.schonherz.homework.order.service.OrderService;
import hu.schonherz.homework.order.service.mapper.OrderMapper;
import hu.schonherz.homework.order.vo.OrderVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;

	// Create a new order
	@Override
	public void addOrder(OrderVo orderVo) throws Exception {
		orderDao.save(OrderMapper.toDto(orderVo));
	}

	// Return all order
	@Override
	public List<OrderVo> getAllOrder() throws Exception {
		return OrderMapper.toVo(orderDao.findAll());
	}
}
