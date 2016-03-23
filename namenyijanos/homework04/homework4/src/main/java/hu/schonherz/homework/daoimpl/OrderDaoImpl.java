package hu.schonherz.homework.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.connection.ConnectionHandler;
import hu.schonherz.homework.dao.OrderDao;
import hu.schonherz.homework.records.Order;

public class OrderDaoImpl implements OrderDao {

	private Connection con;

	//create connection
	public OrderDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			System.out.println("Could not establish connection");
			e.printStackTrace();
		}
	}

	public List<Order> getAllOrders() {
		//SQL statement in a String; will be executed as a query
		String sql = "SELECT user_id, product_id FROM public.\"Order\"";
		List<Order> orders = new ArrayList<>();
		//create statement in try-with block (auto resource management)
		try (Statement stmt = con.createStatement()) {
			//execute query in result set in try-with block
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					//add actual order to the orders list
					orders.add(new Order(rs.getInt("user_id"), rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			//handling SQLException in catch
			e.printStackTrace();
		}
		return orders;
	}

	public void addOrder(Order order) {
		//SQL statement in a String; will be executed as a prepared statement
		//question marks are placeholders
		String sql = "INSERT INTO public.\"Order\" (user_id, product_id) VALUES (?, ?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			//fill the placeholders with valid data
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			//execute the completed statement
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteAllOrderOfUser(Order order) {
		//it will delete all the orders which have the given user id
		String sql = "DELETE FROM public.\"Order\" WHERE user_id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getUserId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteOrder(Order order) {
		//it will delete all the orders wich has the given user id (!)and(!) product id
		String sql = "DELETE FROM public.\"Order\" WHERE user_id = ? AND product_id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, order.getUserId());
			stmt.setInt(2, order.getProductId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
