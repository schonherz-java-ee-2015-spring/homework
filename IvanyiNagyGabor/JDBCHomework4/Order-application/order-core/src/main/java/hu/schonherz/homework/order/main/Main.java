package hu.schonherz.homework.order.main;

import java.sql.Connection;
import java.sql.SQLException;

import hu.schonherz.homework.order.connection.impl.PostgreSqlConnectionHandler;
import hu.schonherz.homework.order.dao.OrderDao;
import hu.schonherz.homework.order.dao.impl.OrderDaoImpl;
import hu.schonherz.homework.order.dto.Order;

public class Main {

	public static void main(String[] args) {
		
		try (Connection connection = PostgreSqlConnectionHandler.getInstance().getConnection();) {
			OrderDao dao = new OrderDaoImpl(connection);
//			userDao.addUser(new User(0, "Pamacska"));

			dao.deleteOrder(new Order(3, 1));
			dao.getAllOrders().forEach(System.out::println);
//			dao.getOrdersByProductId(3).forEach(System.out::println);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
