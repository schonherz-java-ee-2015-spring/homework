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

	/**
	 * Return the all order from the Order table
	 */
	@Override
	public List<Order> getAllOrder() {
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

	/**
	 * Return the all Order from the Order table where user_id = id
	 */
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

	/**
	 * Return the all Order from the Order table where product_id = id
	 */
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

	/**
	 * Insert a new Order into the Order table
	 */
	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?, ?);";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, order.getUserId());
			statement.setInt(2, order.getProductId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update an old Order to a new Order in the Order table
	 */
	@Override
	public void updateOrder(Order oldOrder, Order newOrder) {
		String sql = "UPDATE public.\"Order\" SET user_id=?, product_id=? WHERE user_id=? and product_id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, newOrder.getUserId());
			statement.setInt(2, newOrder.getProductId());
			statement.setInt(3, oldOrder.getUserId());
			statement.setInt(4, oldOrder.getProductId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Delete an Order from the Order table
	 */
	@Override
	public void deleteOrder(Order order) {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id=? and product_id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, order.getUserId());
			statement.setInt(2, order.getProductId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
