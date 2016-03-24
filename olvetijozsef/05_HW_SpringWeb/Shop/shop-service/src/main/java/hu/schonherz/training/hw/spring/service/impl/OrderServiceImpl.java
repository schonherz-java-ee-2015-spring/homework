package hu.schonherz.training.hw.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.training.hw.spring.dao.OrderDAO;
import hu.schonherz.training.hw.spring.service.OrderService;
import hu.schonherz.training.hw.spring.service.mapper.OrderMapper;
import hu.schonherz.training.hw.spring.service.mapper.UserMapper;
import hu.schonherz.training.hw.spring.vo.OrderVo;
import hu.schonherz.training.hw.spring.vo.UserVo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;

	@Override
	public void addOrder(OrderVo order) {
		orderDAO.addOrder(order.getUserId(), order.getProductId());
	}

	@Override
	public void updateOrder(OrderVo order) {
		orderDAO.updateOrder(OrderMapper.toDto(order));
	}

	@Override
	public void deleteOrder(OrderVo order) {
		orderDAO.deleteOrder(order.getId());
	}

	@Override
	public OrderVo getOrderById(Integer id) {
		return OrderMapper.toVo(orderDAO.getOrderById(id));
	}

	@Override
	public List<OrderVo> getOrdersByUser(UserVo user) {
		return OrderMapper.toVo(orderDAO.getOrdersByUser(UserMapper.toDto(user)));
	}

	@Override
	public List<OrderVo> getAllOrders() {
		return OrderMapper.toVo(orderDAO.getAllOrders());
	}

}
