package hu.schonherz.homework.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.connection.ConnectionHandler;
import hu.schonherz.homework.dao.ProductDao;
import hu.schonherz.homework.records.Product;

public class ProductDaoImpl implements ProductDao {
	
	private Connection con;
	
	//create connection
	public ProductDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			System.out.println("Could not establish connection");
			e.printStackTrace();
		}
	}

	public List<Product> getAllProducts() {
		//SQL statement in a String; will be executed as a query
		String sql = "SELECT id, price, name FROM public.\"Product\"";
		List<Product> products = new ArrayList<>();
		//create statement in try-with block (auto resource management)
		try (Statement stmt = con.createStatement()) {
			//execute query in result set in try-with block
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					//add actual product to the products list
					products.add(new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			//handling SQLException in catch
			e.printStackTrace();
		}
		return products;
	}

	public Product getProduct(String name) {
		String sql = "SELECT id, price, name FROM public.\"Product\" WHERE name = ?";
		Product product = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery()) {
				while(rs.next()) {
					product = new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			
		}
		return product;
	}

	public void addProduct(Product product) {
		//SQL statement in a String; will be executed as a prepared statement
		//question marks are placeholders
		String sql = "INSERT INTO public.\"Product\" (price, name) VALUES (?, ?) ;";
		//create a prepared statement
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			//fill the placeholders with valid data
			stmt.setInt(1, product.getPrice());
			stmt.setString(2, product.getName());
			//execute statement 
			stmt.execute();
			//generates id (primary key --> unique)
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int productId = rs.getInt("id");
				product.setId(productId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateProduct(Product product) {
		String sql = "UPDATE public.\"Product\" SET price = ?, name = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, product.getPrice());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteProduct(Product product) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
