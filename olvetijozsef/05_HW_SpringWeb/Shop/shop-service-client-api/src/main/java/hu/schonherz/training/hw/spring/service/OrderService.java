package hu.schonherz.training.hw.spring.service;

import java.util.List;

import hu.schonherz.training.hw.spring.vo.OrderVo;
import hu.schonherz.training.hw.spring.vo.UserVo;

public interface OrderService {

	void addOrder(OrderVo order);

	void updateOrder(OrderVo order);

	void deleteOrder(OrderVo order);

	OrderVo getOrderById(Integer id);

	List<OrderVo> getOrdersByUser(UserVo user);

	List<OrderVo> getAllOrders();

}
