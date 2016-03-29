package hu.schonherz.homework.webshop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.schonherz.homework.webshop.dao.OrderDao;
import hu.schonherz.homework.webshop.dto.Order;
import hu.schonherz.homework.webshop.service.OrderService;
import hu.schonherz.homework.webshop.vo.ProductVo;
import hu.schonherz.homework.webshop.vo.UserVo;


@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void addOrder(UserVo user, ProductVo product) {
		Order order = new Order();
		order.setUserId(user.getId());
		order.setProductId(product.getId());
		orderDao.addOrder(order);
	}

	@Override
	public void addOrder(int userId, int productId) {
		Order order = new Order();
		order.setUserId(userId);
		order.setProductId(productId);
		orderDao.addOrder(order);
	}

}
