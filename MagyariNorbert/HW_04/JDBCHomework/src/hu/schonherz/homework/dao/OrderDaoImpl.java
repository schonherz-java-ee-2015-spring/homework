package hu.schonherz.homework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.jdbc.ConnectionHandler;
import hu.schonherz.homework.records.Order;

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
	public List<Order> getAllOrder() {
		String sql = "SELECT product_id, user_id FROM public.\"Order\"";
		List<Order> orders = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					orders.add(new Order(rs.getInt("product_id"), rs.getInt("user_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}


	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?, ?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateOrder(Order order) {
		String sql = "UPDATE public.\"Order\" SET product_id=?, user_id=? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getProductId());
			stmt.setInt(2, order.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteOrder(Order order) {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id= ? AND product_id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
