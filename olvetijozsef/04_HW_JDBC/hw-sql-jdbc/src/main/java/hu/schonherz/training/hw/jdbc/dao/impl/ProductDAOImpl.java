package hu.schonherz.training.hw.jdbc.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.hw.jdbc.ConnectionManager;
import hu.schonherz.training.hw.jdbc.dao.ProductDAO;
import hu.schonherz.training.hw.jdbc.entity.Product;

public class ProductDAOImpl implements ProductDAO {
	private Connection con;

	public ProductDAOImpl() {
		try {
			con = ConnectionManager.getPostgreConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addProduct(Product product) {
		String sql = "INSERT INTO public.\"Product\" (name,price) VALUES (?,?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
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
		String sql = "UPDATE public.\"Product\" SET name = ?, price = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, product.getName());
			stmt.setDouble(2, product.getPrice());
			stmt.setInt(3, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product getProductById(int id) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?";
		Product product = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					product = new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "{call \"getProducts\"()}";
		List<Product> products = new ArrayList<Product>();
		try (CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					products.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getDouble("price")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

}
