package hu.shonherz.training.homework4.dao.impl.test;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.schonherz.training.homework4.dao.OrderDao;
import hu.schonherz.training.homework4.dao.ProductDao;
import hu.schonherz.training.homework4.dao.UserDao;
import hu.schonherz.training.homework4.dao.impl.OrderDaoImpl;
import hu.schonherz.training.homework4.dao.impl.ProductDaoImpl;
import hu.schonherz.training.homework4.dao.impl.UserDaoImpl;
import hu.schonherz.training.homework4.dto.Order;
import hu.schonherz.training.homework4.dto.Product;
import hu.schonherz.training.homework4.dto.User;

@SuppressWarnings("javadoc")
public class OrderDaoImplTest {

	OrderDao orderDao;
	UserDao userDao;
	ProductDao productDao;
	User user;
	Product product;
	
	
	private void createUser(){

		user = new User();
		user.setName("test" + new Random().nextInt());
		userDao.createUser(user);

		user = userDao.findUserByName(user.getName());
	}
	
	private void createProduct(){

		product = new Product();
		product.setName("test" + new Random().nextInt());
		product.setPrice(Math.abs(new Random().nextInt()));
		
		productDao.createProduct(product);
		
		
		product = productDao.findProductByName(product.getName());
		
	}
	
	@Before
	public void setUp() throws Exception {
		orderDao = new OrderDaoImpl();
		userDao = new UserDaoImpl();
		productDao = new ProductDaoImpl();


		createUser();
		createProduct();

	}


	@Test
	public void testFindOrdersByUserIdAndFindOrderById() {
		orderDao.createOrder(user.getId(), product.getId());
		
		List<Order> orders = orderDao.findOrdersByUserId(user.getId());
		
		Assert.assertNotEquals(0, orders.size());
		
		
		Order order2 = orders.get(0);
		
		
		Assert.assertEquals(order2.getId(), orderDao.findOrderById(order2.getId()).getId());
	}

	@Test
	public void testFindOrdersByProductId() {
		orderDao.createOrder(user.getId(), product.getId());
		
		List<Order> orders = orderDao.findOrdersByUserIdAndProductId(user.getId(), product.getId());
		
		Assert.assertNotEquals(0, orders.size());
	}

	@Test
	public void testFindOrdersByUserIdAndProductId() {
		orderDao.createOrder(user.getId(), product.getId());
		
		List<Order> orders = orderDao.findOrdersByUserIdAndProductId(user.getId(), product.getId());
		
		Assert.assertNotEquals(0, orders.size());
		
	}

	@Test
	public void testCreateOrderGetAllOrders() {
		Integer ordersize = orderDao.getAllOrders().size();
		orderDao.createOrder(user.getId(), product.getId());
		
		
		
		
		Assert.assertEquals(ordersize+1, orderDao.getAllOrders().size());
		
		
		
		
		
	}

}
