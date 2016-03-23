package hu.schonherz.homework.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.order.connection.ConnectionHandler;
import hu.schonherz.homework.order.dao.OrderDao;
import hu.schonherz.homework.order.dao.impl.OrderDaoImpl;
import hu.schonherz.homework.order.dto.Order;
import hu.schonherz.homework.order.service.OrderService;
import hu.schonherz.homework.order.service.mapper.OrderMapper;
import hu.schonherz.homework.order.vo.OrderVo;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;

	public OrderServiceImpl() throws SQLException {
		this.orderDao = new OrderDaoImpl(ConnectionHandler.getConnection());
	}
	
	/**
	 * Return the all Order from the Order table
	 */
	@Override
	public List<OrderVo> getAllOrder() {
		List<Order> orders = orderDao.getAllOrder();
		return OrderMapper.toVo(orders);
	}
	
	/**
	 * Return the all Order from the Order table where (user)id = id
	 */
	@Override
	public List<OrderVo> getOrdersByUserId(Integer id) {
		List<Order> orders = orderDao.getOrdersByUserId(id);
		return OrderMapper.toVo(orders);
	}

}
