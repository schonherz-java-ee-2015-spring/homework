package hu.schonherz.training.homework4.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.homework4.connection.DBConnection;
import hu.schonherz.training.homework4.dao.OrderDao;
import hu.schonherz.training.homework4.dao.ProductDao;
import hu.schonherz.training.homework4.dao.UserDao;
import hu.schonherz.training.homework4.dto.Order;

/**
 * Postgresql JDBC implementation of OrderDao
 * 
 * @author Mark Bohan
 *
 */
public class OrderDaoImpl implements OrderDao {

	private Connection connection;
	private UserDao userDao;
	private ProductDao productDao;

	@SuppressWarnings("javadoc")
	public OrderDaoImpl() {
		super();
		try {
			this.connection = DBConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		this.userDao = new UserDaoImpl();
		this.productDao = new ProductDaoImpl();

	}

	@Override
	public Order findOrderById(Integer id) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE id = ?";
		Order order = new Order();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					order.setId(rs.getInt("id"));
					order.setUser(userDao.findUserById(rs.getInt("user_id")));
					order.setProduct(productDao.findProductById(rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public List<Order> findOrdersByUserId(Integer userId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE user_id = ?";
		List<Order> orders = new ArrayList<Order>();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
					order.setUser(userDao.findUserById(rs.getInt("user_id")));
					order.setProduct(productDao.findProductById(rs.getInt("product_id")));
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public List<Order> findOrdersByProductId(Integer productId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE product_id = ?";
		List<Order> orders = new ArrayList<Order>();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, productId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
					order.setUser(userDao.findUserById(rs.getInt("user_id")));
					order.setProduct(productDao.findProductById(rs.getInt("product_id")));
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public List<Order> findOrdersByUserIdAndProductId(Integer userId, Integer productId) {
		String sql = "SELECT id, user_id, product_id FROM public.\"Order\" WHERE product_id = ? AND user_id = ?";
		List<Order> orders = new ArrayList<Order>();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, productId);
			stmt.setInt(2, userId);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					Order order = new Order();
					order.setId(rs.getInt("id"));
					order.setUser(userDao.findUserById(rs.getInt("user_id")));
					order.setProduct(productDao.findProductById(rs.getInt("product_id")));
					orders.add(order);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public List<Order> getAllOrders() {
		String sql = "{call public.\"getOrders\"() }";
		List<Order> orders = new ArrayList<Order>();
		try (CallableStatement cstmt = connection.prepareCall(sql)) {
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				Order order = new Order();

				order.setId(rs.getInt("id"));
				order.setUser(userDao.findUserById(rs.getInt("user_id")));
				order.setProduct(productDao.findProductById(rs.getInt("product_id")));
				orders.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;
	}

	@Override
	public void createOrder(Integer userId, Integer productId) {
		String sql = "INSERT INTO public.\"Order\"(user_id, product_id) VALUES ( ? , ? );";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			pstmt.setInt(2, productId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
