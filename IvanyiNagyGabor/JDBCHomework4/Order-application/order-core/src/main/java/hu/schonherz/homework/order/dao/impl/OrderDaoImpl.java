package hu.schonherz.homework.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.order.dao.OrderDao;
import hu.schonherz.homework.order.dto.Order;

public class OrderDaoImpl implements OrderDao {

	private static Connection connection = null;
	
	public OrderDaoImpl(Connection connection) {
		OrderDaoImpl.connection = connection;
	}
	
	
	@Override
	public List<Order> getAllOrders() {
		String sql = "SELECT user_id, product_id FROM public.\"Order\";";
		List<Order> orders = new ArrayList<Order>();
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
			while (resultSet.next()) {
				orders.add(new Order(resultSet.getInt("user_id"), resultSet.getInt("product_id")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersByUserId(Integer id) {
		String sql = "SELECT user_id, product_id FROM public.\"Order\" WHERE user_id = ?;";
		List<Order> orders = new ArrayList<Order>();
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					orders.add(new Order(resultSet.getInt("user_id"), resultSet.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersByProductId(Integer id) {
		String sql = "SELECT user_id, product_id FROM public.\"Order\" WHERE product_id = ?;";
		List<Order> orders = new ArrayList<Order>();
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				while (resultSet.next()) {
					orders.add(new Order(resultSet.getInt("user_id"), resultSet.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?, ?);";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, order.getUser_id());
			statement.setInt(2, order.getProduct_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Order oldOrder, Order newOrder) {
		String sql = "UPDATE public.\"Order\" SET user_id=?, product_id=? WHERE user_id=? and product_id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, newOrder.getUser_id());
			statement.setInt(2, newOrder.getProduct_id());
			statement.setInt(3, oldOrder.getUser_id());
			statement.setInt(4, oldOrder.getProduct_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(Order order) {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id=? and product_id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, order.getUser_id());
			statement.setInt(2, order.getProduct_id());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
