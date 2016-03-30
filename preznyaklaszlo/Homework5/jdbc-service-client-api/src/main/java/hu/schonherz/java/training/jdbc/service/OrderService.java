package hu.schonherz.java.training.jdbc.service;

import java.util.List;

import hu.schonherz.java.training.jdbc.vo.OrderVo;

public interface OrderService {

	public List<OrderVo> getAllOrders();

	public void addOrder(OrderVo order);

	public void deleteOrder(OrderVo order);

}
