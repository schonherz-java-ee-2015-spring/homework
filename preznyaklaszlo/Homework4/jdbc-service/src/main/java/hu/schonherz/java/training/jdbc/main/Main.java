package hu.schonherz.java.training.jdbc.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.jdbc.connection.ConnectionHandler;
import hu.schonherz.java.training.jdbc.dao.OrderDao;
import hu.schonherz.java.training.jdbc.dao.ProductDao;
import hu.schonherz.java.training.jdbc.dao.UserDao;
import hu.schonherz.java.training.jdbc.dao.impl.OrderDaoImpl;
import hu.schonherz.java.training.jdbc.dao.impl.ProductDaoImpl;
import hu.schonherz.java.training.jdbc.dao.impl.UserDaoImpl;
import hu.schonherz.java.training.jdbc.records.Order;
import hu.schonherz.java.training.jdbc.records.Product;
import hu.schonherz.java.training.jdbc.records.User;

public class Main {

	public static void main(String[] args) {

		UserDao userDao = new UserDaoImpl();
		ProductDao productDao = new ProductDaoImpl();
		OrderDao orderDao = new OrderDaoImpl();

		// Egy adott felhasználó rendeléseinek lekérdezése (PreparedStatement)

		List<Product> productList = new ArrayList<Product>();
		User user = userDao.getUserByName("Kiss Lajos");
		productList = userDao.getOrdersOfAUser(user);

		System.out.println("Products ordered by Kiss Lajos: ");
		for (Product product : productList) {
			System.out.println("Product name: " + product.getName());
		}

		System.out.println("----------------------------------------");
		// Felhasználók lekérdezése (CallableStatement)

		List<User> userList = userDao.getAllUsers();

		for (User us : userList) {
			System.out.println(us.getName());
		}
		System.out.println("----------------------------------------");

		// Termékek lekérdezése (CallableStatement)

		List<Product> productList2 = productDao.getAllProducts();

		for (Product prod : productList2) {
			System.out.println(prod.getName() + ", ára: " + prod.getPrice());
		}
		System.out.println("----------------------------------------");

		// Rendelések lekérdezése (Statement)
		List<Order> orderList = orderDao.getAllOrders();

		for (Order order : orderList) {
			System.out.println("User id: " + order.getUserId() + ", Product id: " + order.getProductId());
		}
		System.out.println("----------------------------------------");

		// Termékek kötegelt beszúrása tetszőleges számban (azért több mint 5)
		// és tetszőleges kötegméretben

		int batchSize = 2, count = 0;
		String sql = "INSERT INTO public.\"Product\" (price,name) VALUES (?,?)";

		List<Product> newProducts = new ArrayList<Product>();
		newProducts.add(new Product(0, 2000, "Borotva"));
		newProducts.add(new Product(0, 2500, "Fogkefe"));
		newProducts.add(new Product(0, 1800, "Borotvahab"));
		newProducts.add(new Product(0, 1100, "Arcszesz"));
		newProducts.add(new Product(0, 200, "Gumicukor"));
		newProducts.add(new Product(0, 750, "Imodium tabletta"));

		try (Connection con = ConnectionHandler.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql)) {
			con.setAutoCommit(false);
			for (Product product : newProducts) {
				pstmt.setInt(1, product.getPrice());
				pstmt.setString(2, product.getName());
				pstmt.addBatch();
				System.out.println("Product " + product.getName() + " added to batch...");
				if (++count % batchSize == 0) {
					pstmt.executeBatch();
				}
			}
			pstmt.executeBatch();
			con.commit();
			System.out.println("Committed");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("----------------------------------------");

		// Termékek kötegelt törlése tetszőleges számban és tetszőleges
		// kötegméretben
		String sql2 = "DELETE FROM public.\"Product\" WHERE name=?;";
		try (Connection con = ConnectionHandler.getConnection(); PreparedStatement pstmt = con.prepareStatement(sql2)) {
			con.setAutoCommit(false);
			for (Product product : newProducts) {
				pstmt.setString(1, product.getName());
				pstmt.addBatch();
				System.out.println("Product " + product.getName() + " added to batch...");
				if (++count % batchSize == 0) {
					pstmt.executeBatch();
				}
			}
			pstmt.executeBatch();
			con.commit();
			System.out.println("Products deleted$");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
