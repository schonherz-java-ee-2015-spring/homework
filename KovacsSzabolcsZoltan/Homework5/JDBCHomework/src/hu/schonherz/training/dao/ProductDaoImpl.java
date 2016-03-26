package hu.schonherz.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.connection.ConnectionHandler;
import hu.schonherz.training.pojo.Product;

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
	public List<Product> getAllProducts() {
		String sql = "SELECT id, name, price FROM public.\"Product\"";
		List<Product> products = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					products.add(new Product(rs.getString("name"), rs.getInt("id"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProduct(String name) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE name = ?";
		Product product = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					product = new Product(rs.getString("name"), rs.getInt("id"), rs.getInt("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?,?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getPrice());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int Id = rs.getInt("id");
				product.setId(Id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE public.\"Product\" SET name = ?, price = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getPrice());
			stmt.setInt(3, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		String sql = "DELETE FROM public.\"Product\" WHERE name = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, product.getName());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
