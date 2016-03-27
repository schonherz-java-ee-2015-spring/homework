package hu.schonherz.atka.jdbchomework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.atka.jdbchomework.connection.ConnectionHandler;
import hu.schonherz.atka.jdbchomework.pojo.Order;

public class OrderDaoImpl implements Dao<Order> {

	private Connection connection;

	public OrderDaoImpl() {
		try {
			connection = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while building connection!");
		}
	}

	public void addElement(Order order) {
		String sql = "INSERT INTO public.\"Order\" (product_id, user_id) VALUES (?,?) ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, order.getProductId());
			stmt.setInt(2, order.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while adding order!");
		}
	}

	@Deprecated
	public void updateElement(Order order) {
		String sql = "UPDATE public.\"Order\" SET product_id = ? WHERE user_id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, order.getProductId());
			stmt.setInt(2, order.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while updating order by user ID!");
		}
		sql = "UPDATE public.\"Order\" SET user_id = ? WHERE product_id = ?;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, order.getProductId());
			stmt.setInt(2, order.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while updating order by product ID!");
		}
	}

	public void deleteElement(Order order) {
		String sql = "DELETE FROM public.\"Order\" WHERE product_id = ? , user_id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, order.getProductId());
			stmt.setInt(2, order.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while deleting order!");
		}
	}
	
	// Task 2.a
	public List<Order> getOrdersFromUserIdByPreparedStatement(int userId) {
		List<Order> result = new ArrayList<>();
		String sql = "SELECT product_id, user_id FROM public.\"Order\" WHERE user_id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					result.add(new Order(rs.getInt("product_id"), rs.getInt("user_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while reading orders by user ID!");
		}
		return result;
	}
	
	// Task 2.d
	public List<Order> selectOrdersByStatement() {
		List<Order> result = new ArrayList<>();
		String sql = "SELECT product_id, user_id FROM public.\"Order\" ;";
		try (Statement stmt = connection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					result.add(new Order(rs.getInt("product_id"), rs.getInt("user_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while reading all orders!");
		}
		return result;
	}
}
