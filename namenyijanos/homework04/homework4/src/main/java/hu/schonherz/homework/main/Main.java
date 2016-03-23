package hu.schonherz.homework.main;

import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.dao.OrderDao;
import hu.schonherz.homework.dao.ProductDao;
import hu.schonherz.homework.dao.UserDao;
import hu.schonherz.homework.daoimpl.OrderDaoImpl;
import hu.schonherz.homework.daoimpl.ProductDaoImpl;
import hu.schonherz.homework.daoimpl.UserDaoImpl;
import hu.schonherz.homework.metadata.GetMetadata;
import hu.schonherz.homework.records.Order;
import hu.schonherz.homework.records.Product;
import hu.schonherz.homework.records.User;


public class Main {

	public static void main(String[] args) {
		metadata();
		testGetAllUsers();
		testGetAllProducts();
		testGetAllOrders();
	}

	public static void metadata() {
		try {
			GetMetadata.printGeneralMetadata();
			// Print all the tables of the database scheme, with their names and
			// structure
			GetMetadata.getColumnsMetadata(GetMetadata.getTablesMetadata());
		} catch (SQLException e) {
			System.err.println("There was an error retrieving the metadata properties: " + e.getMessage());
		}
	}
	
	public static void testGetAllUsers() {
		UserDao dao = new UserDaoImpl();
		List<User> users = dao.getAllUsers();
		System.out.println("--- Users ---");
		System.out.println("---id:name---");
		System.out.println("-----------------------------------");
		for (User user : users) {
			System.out.println(user);
		}
		System.out.println("-----------------------------------");
		System.out.println();
	}
	
	public static void testGetAllProducts() {
		ProductDao dao = new ProductDaoImpl();
		List<Product> products = dao.getAllProducts();
		System.out.println("--- Products ---");
		System.out.println("---id:price:name---");
		System.out.println("-----------------------------------");
		for (Product product : products) {
			System.out.println(product);
		}
		System.out.println("-----------------------------------");
		System.out.println();
	}
	
	public static void testGetAllOrders() {
		OrderDao dao = new OrderDaoImpl();
		List<Order> orders = dao.getAllOrders();
		System.out.println("--- Orders ---");
		System.out.println("---user_id:product_id---");
		System.out.println("-----------------------------------");
		for (Order order : orders) {
			System.out.println(order);
		}
		System.out.println("-----------------------------------");
		System.out.println();
	}
}
