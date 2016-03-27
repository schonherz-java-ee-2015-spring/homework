package hu.schonherz.training.hw.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.hw.jdbc.ConnectionManager;
import hu.schonherz.training.hw.jdbc.dao.OrderDAO;
import hu.schonherz.training.hw.jdbc.entity.Order;
import hu.schonherz.training.hw.jdbc.entity.User;

/**
 * 
 * @author Ölveti József
 *
 */
public class OrderDAOImpl implements OrderDAO {
	private Connection con;

	public OrderDAOImpl() {
		try {
			con = ConnectionManager.getPostgreConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO public.\"Order\" (user_id,product_id) VALUES (?,?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int orderId = rs.getInt("id");
				order.setId(orderId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "UPDATE public.\"Order\" SET user_id = ?, product_id = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.setInt(3, order.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrder(Order order) {
		String sql = "DELETE FROM public.\"Order\" WHERE id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Order getOrderById(int id) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE id = ?";
		Order order = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					order = new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}

	@Override
	public List<Order> getOrdersByUser(User user) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE user_id = ?;";
		List<Order> orders = new ArrayList<Order>();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, user.getId());
			try (ResultSet rs = stmt.executeQuery()) {
				while(rs.next()){
					orders.add(new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\";";
		List<Order> orders = new ArrayList<Order>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					orders.add(new Order(rs.getInt("id"), rs.getInt("user_id"), rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

}
