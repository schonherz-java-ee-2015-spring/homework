package hu.schonherz.java.training.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.java.training.jdbc.connection.ConnectionHandler;
import hu.schonherz.java.training.jdbc.dao.ProductDao;
import hu.schonherz.java.training.jdbc.records.Product;

public class ProductDaoImpl implements ProductDao {
	private Connection con;

	public ProductDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product getProductByName(String name) {
		String sql = "SELECT * FROM public.\"Product\" WHERE name = ?";
		Product product = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					product = new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();
		String sql = "SELECT * FROM public.\"Product\"";
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					products.add(new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "INSERT INTO public.\"Product\" (price,name) VALUES (?,?)";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, product.getPrice());
			stmt.setString(2, product.getName());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int productId = rs.getInt("id");
				product.setId(productId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE public.\"Product\" SET price = ? name = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, product.getPrice());
			stmt.setString(2, product.getName());
			stmt.setInt(3, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
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
