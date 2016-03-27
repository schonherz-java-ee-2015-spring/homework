package hu.schonherz.atka.jdbchomework.test;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import hu.schonherz.atka.jdbchomework.dao.OrderDaoImpl;
import hu.schonherz.atka.jdbchomework.dao.ProductDaoImpl;
import hu.schonherz.atka.jdbchomework.dao.UserDaoImpl;
import hu.schonherz.atka.jdbchomework.pojo.Order;
import hu.schonherz.atka.jdbchomework.pojo.Product;
import hu.schonherz.atka.jdbchomework.pojo.User;

public class DaoTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		OrderDaoImpl orderDao = new OrderDaoImpl();
		ProductDaoImpl productDao = new ProductDaoImpl();
		UserDaoImpl userDao = new UserDaoImpl();

		List<Order> orders = orderDao.selectOrdersByStatement();
		List<Product> products = productDao.selectProductsByCallableStatement();
		List<User> users = userDao.selectUsersByCallableStatement();

		for (Order order : orders) {
			System.out.println(order.toString());
		}
		for (Product product : products) {
			System.out.println(product.toString());
		}
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

}
