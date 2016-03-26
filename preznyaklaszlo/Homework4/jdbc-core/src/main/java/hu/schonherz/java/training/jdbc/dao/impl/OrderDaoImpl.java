package hu.schonherz.java.training.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.jdbc.connection.ConnectionHandler;
import hu.schonherz.java.training.jdbc.dao.OrderDao;
import hu.schonherz.java.training.jdbc.records.Order;

public class OrderDaoImpl implements OrderDao {

	private Connection con;

	public OrderDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> getAllOrders() {
		String sql = "SELECT * FROM public.\"Order\"";
		List<Order> orders = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					orders.add(new Order(rs.getInt("user_id"), rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO public.\"Order\" (user_id,product_id) VALUES (?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(Order order) {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id = ? AND product_id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
