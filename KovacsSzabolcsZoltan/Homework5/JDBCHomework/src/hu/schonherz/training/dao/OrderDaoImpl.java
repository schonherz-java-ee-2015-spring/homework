package hu.schonherz.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.connection.ConnectionHandler;
import hu.schonherz.training.pojo.Order;

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
		String sql = "SELECT user_id, product_id FROM public.\"Order\"";
		List<Order> orders = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					orders.add(new Order(rs.getInt("user_id"), rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orders;
	}

//	@Override
//	public List<Integer> getProductIdByUserId(int user_id) {
//		String sql = "SELECT product_id FROM public.\"Order\" WHERE product_id = ?";
//		List<Integer> productlist = new ArrayList<>();
//		try (PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, user_id);
//			try (ResultSet rs = stmt.executeQuery();) {
//				productlist.add(rs.getInt("product_id"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return productlist;
//	}
//
//	@Override
//	public List<Integer> getUserIdByProductId(int product_id) {
//		String sql = "SELECT user_id, product_id FROM public.\"Order\" WHERE user_id = ?";
//		List<Integer> userlist = new ArrayList<>();
//		try (PreparedStatement stmt = con.prepareStatement(sql)) {
//			stmt.setInt(1, product_id);
//			try (ResultSet rs = stmt.executeQuery();) {
//				userlist.add(rs.getInt("user_id"));
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return userlist;
//	}

	@Override
	public void addOrder(Order order) {
		String sql = "INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?,?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, order.getUserID());
			stmt.setInt(2, order.getProductID());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "UPDATE public.\"Order\" SET product_id = ? WHERE user_id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getProductID());
			stmt.setInt(2, order.getUserID());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteOrderByUserId(Integer user_id) {
		String sql = "DELETE FROM public.\"Order\" WHERE user_id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, user_id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
