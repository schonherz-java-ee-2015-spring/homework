package hu.schonerz.java.training.hw5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.schonerz.java.training.hw5.service.OrderService;
import hu.schonerz.java.training.hw5.vo.ProductVo;
import hu.schonerz.java.training.hw5.vo.UserVo;
import hu.schonherz.java.training.hw5.dao.OrderDao;
import hu.schonherz.java.training.hw5.dto.Order;

// Tells spring that this class is a service class.
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Override
	public void addOrder(UserVo user, ProductVo product) {
		Order order = new Order();
		order.setUser_id(user.getId());
		order.setProduct_id(product.getId());
		
		orderDao.addOrder(order);
	}

	@Override
	public void addOrder(int user_id, int product_id) {
		orderDao.addOrder(user_id, product_id);
	}

}
