package hu.schonherz.homework.order.service.impl;

import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.order.connection.impl.PostgreSqlConnectionHandler;
import hu.schonherz.homework.order.dao.OrderDao;
import hu.schonherz.homework.order.dao.impl.OrderDaoImpl;
import hu.schonherz.homework.order.dto.Order;
import hu.schonherz.homework.order.service.OrderService;
import hu.schonherz.homework.order.service.mapper.OrderMapper;
import hu.schonherz.homework.order.vo.OrderVo;

public class OrderServiceImpl implements OrderService {

	private OrderDao orderDao;

	public OrderServiceImpl() throws SQLException {
		this.orderDao = new OrderDaoImpl(PostgreSqlConnectionHandler.getInstance().getConnection());
	}
	@Override
	public List<OrderVo> getAllOrder() {
		List<Order> orders = orderDao.getAllOrders();
		return OrderMapper.toVo(orders);
	}
	@Override
	public List<OrderVo> getOrdersByUserId(Integer id) {
		List<Order> orders = orderDao.getOrdersByUserId(id);
		return OrderMapper.toVo(orders);
	}

}
