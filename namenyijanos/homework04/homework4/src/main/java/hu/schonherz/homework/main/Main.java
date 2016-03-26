package hu.schonherz.homework.main;

import java.sql.SQLException;
import java.util.List;

import hu.schonherz.homework.batch.BatchDelete;
import hu.schonherz.homework.batch.BatchInsert;
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
		
		System.out.println("Get metadata");
		System.out.println("-------------");
		metadata();
		
		System.out.println("Get orders of a specific user with prepared statement");
		System.out.println("-------------");
		preparedStatementForOrderByUser();
		System.out.println();
		
		System.out.println("Get all users with callable statement");
		System.out.println("-------------");
		callableStatementForUsers();
		System.out.println();
		
		System.out.println("Get all products with callable statement");
		System.out.println("-------------");
		callableStatementForProducts();
		System.out.println();
		
		System.out.println("Get all orders with statement");
		System.out.println("-------------");
		statementForOrders();
		System.out.println();
		
		System.out.println("Batch insert products");
		System.out.println("-------------");
		BatchInsert.insertData();
		System.out.println();
		
		System.out.println("Get all products after batch insert");
		System.out.println("-------------");
		callableStatementForProducts();
		System.out.println();
		
		System.out.println("Batch delete products");
		System.out.println("-------------");
		BatchDelete.deleteData();
		System.out.println();
		
		System.out.println("Get all products after batch delete");
		System.out.println("-------------");
		callableStatementForProducts();
		System.out.println();
	}

	public static void metadata() {
		try {
			GetMetadata.printGeneralMetadata();
			GetMetadata.getColumnsMetadata(GetMetadata.getTablesMetadata());
		} catch (SQLException e) {
			System.err.println("There was an error retrieving the metadata properties: " + e.getMessage());
		}
	}
	
	public static void preparedStatementForOrderByUser() {
		OrderDao order = new OrderDaoImpl();
		List<Order> orders;
		orders = order.getAllOrdersOfUser(1);
		for (Order or : orders) {
			System.out.println("User-id: " + or.getUserId() + "\t Product-id: " + or.getProductId() + ".");
		}
	}
	
	public static void callableStatementForUsers() {
		UserDao usr = new UserDaoImpl();
		List<User> users;
		users = usr.getUsersCS();
		for (User user : users) {
			System.out.println("Id: " + user.getId() + "\t Name: " + user.getName());
		}
	}
	
	public static void callableStatementForProducts() {
		ProductDao product = new ProductDaoImpl();
		List<Product> products;
		products = product.getProductsCS();
		for (Product p : products) {
			System.out.println("Id: " + p.getId() + "\t Price: " + p.getPrice() + "\t Name: " + p.getName());
		}
	}
	
	public static void statementForOrders() {
		OrderDao order = new OrderDaoImpl();
		List<Order> orders;
		orders = order.getAllOrders();
		for (Order o : orders) {
			System.out.println("User-id: " + o.getUserId() + "\t Product-id: " + o.getProductId());
		}
	}
}
