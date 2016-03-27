package hu.schonherz.homework.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.jdbc.ConnectionHandler;
import hu.schonherz.homework.records.Order;
import hu.schonherz.homework.records.Product;
import hu.schonherz.homework.records.User;

public class DaoExample {
	public static void main(String[] args) {

		User user = new User(15, "LOLOL");
		List<Product> product = selectUserOrdersByName(user);
		for (Product order : product) {
			System.out.println(order.toString());
		}
		List<User> users= selectAllUser();
		for (User user2 : users) {
			System.out.println(users.size());
			System.out.println(user2);
		}
		
		List<Product> products = selectAllProduct();
		for (Product product2 : products) {
			System.out.println(product2);
		}
		
		List<Order> orders  = selectOrders();
		for (Order order : orders) {
			System.out.println(order);
		}


		
	}
	
	private static List<Product> selectUserOrdersByName(User user) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id IN "
				+ "(SELECT product_id FROM public.\"Order\" WHERE user_id = "
				+ "(SELECT id FROM public.\"User\" WHERE name LIKE ?));";
		List<Product> products = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					products.add(new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	private static List<User> selectAllUser() {

		String sql = "{call \"getUsers\"()}";
		List<User> users = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection();CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					users.add(new User(rs.getInt("id"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	private static List<Product> selectAllProduct() {

		String sql = "{call \"getProducts\"()}";
		List<Product> products = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection();CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					products.add(new Product(rs.getInt("id"),rs.getInt("price"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	private static List<Order> selectOrders() {

		String sql = "SELECT user_id, product_id FROM public.\"Order\"";
		List<Order> orders = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection(); Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					orders.add(new Order(rs.getInt("user_id"),rs.getInt("product_id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orders;

	}
	

}
