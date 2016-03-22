package hu.schonherz.training.query;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.classes.Order;
import hu.schonherz.training.classes.Product;
import hu.schonherz.training.classes.User;
import hu.schonherz.training.connection.ConnectionHandler;

public class Querys {

	private static Connection con;
	
	public static List<Product> getOrdersByUser(String name) {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		List<Product> products = new ArrayList<>();
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id IN (SELECT product_id FROM public.\"Order\" WHERE user_id = (SELECT id FROM public.\"User\" WHERE name LIKE ?));";
		Product product = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			if(stmt != null) {
			}
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery()) {
				if(rs != null) {
				}
				while (rs.next()) {
					product = new Product(rs.getString("name"), rs.getInt("id"), rs.getInt("price"));
					products.add(product);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public static List<User> getAllUser() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection(); CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					users.add(new User(rs.getString("name"), rs.getInt("id")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	
	public static List<Product> getAllProduct() {
		String sql = "SELECT id, name, price FROM public.\"Product\";";
		List<Product> products = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection(); CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					products.add(new Product(rs.getString("name"), rs.getInt("id"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	public static List<Order> getAllOrder() {
		String sql = "SELECT user_id, product_id FROM public.\"Order\"";
		List<Order> orders = new ArrayList<>();
		try (Connection con = ConnectionHandler.getConnection(); Statement stmt = con.createStatement()) {
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
	
	public static void addUsersWithBatchAndBatchSize() {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?)";
		List<User> users = new ArrayList<>();
		users.add(new User("Lakatos Britniszpírsz", 0));
		users.add(new User("Kiss István", 0));
		users.add(new User("Lopez DeFutaztán", 0));
		users.add(new User("Winch Eszter", 0));

		final int batchSize = 2;
		int count = 0;

		try (Connection connection = ConnectionHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (User user : users) {
				statement.setString(1, user.getName());
				statement.addBatch();
				if (++count % batchSize == 0) {
					System.out.println("Count size: " + count);
					System.out.println("Count size reaches the batch size...");
					int[] executedBatchSize = statement.executeBatch();
					System.out.println("Batch executed... Batch Size: " + executedBatchSize.length);
				}
			}
			int[] remainingRows = statement.executeBatch();
			System.out.println("Batch executed for remaining rows... Batch Size: " + remainingRows.length);
			connection.commit();
			System.out.println("Batch commited...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUsersWithBatchAndBatchSize() {
		String sql = "DELETE FROM public.\"User\" WHERE name LIKE ?;";
		List<User> users = new ArrayList<>();
		users.add(new User("Lakatos Britniszpírsz", 0));
		users.add(new User("Kiss István", 0));
		users.add(new User("Lopez DeFutaztán", 0));
		users.add(new User("Winch Eszter", 0));

		final int batchSize = 2;
		int count = 0;

		try (Connection connection = ConnectionHandler.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (User user : users) {
				statement.setString(1, user.getName());
				statement.addBatch();
				if (++count % batchSize == 0) {
					System.out.println("Count size: " + count);
					System.out.println("Count size reaches the batch size...");
					int[] executedBatchSize = statement.executeBatch();
					System.out.println("Batch executed... Batch Size: " + executedBatchSize.length);
				}
			}
			int[] remainingRows = statement.executeBatch();
			System.out.println("Batch executed for remaining rows... Batch Size: " + remainingRows.length);
			connection.commit();
			System.out.println("Batch commited...");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println("---------- Egy adott felhasználó rendeléseinek lekérdezése (Géza) ----------");
		List<Product> products = new ArrayList<>();
		products = getOrdersByUser("Géza");
		for (Product product : products) {
			System.out.println(product);
		}
		
		System.out.println("---------- Felhasználók lekérdezése ----------");
		List<User> users = new ArrayList<>();
		users = getAllUser();
		for (User user : users) {
			System.out.println(user);
		}
		
		System.out.println("---------- Termékek lekérdezése ----------");
		List<Product> productsC = new ArrayList<>();
		productsC = getAllProduct();
		for (Product product : productsC) {
			System.out.println(product);
		}
		
		System.out.println("---------- Rendelések lekérdezése ----------");
		List<Order> orders = new ArrayList<>();
		orders = getAllOrder();
		for (Order order : orders) {
			System.out.println(order);
		}
		
//		addUsersWithBatchAndBatchSize();
		deleteUsersWithBatchAndBatchSize();
	}
}
