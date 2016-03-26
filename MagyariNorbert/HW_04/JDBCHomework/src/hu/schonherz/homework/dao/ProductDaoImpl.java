package hu.schonherz.homework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.jdbc.ConnectionHandler;
import hu.schonherz.homework.records.Product;

public class ProductDaoImpl implements ProductDao{
	private Connection con;
	
	public ProductDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getAllProduct() {
		String sql = "SELECT id, price, name FROM public.\"Product\";";
		List<Product> product = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					product.add(new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public Product getProductByName(String name) {
		String sql = "SELECT id, name, price FROM public.\"Product\" where name = 'Bab';";
		Product product = null;
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					product = new Product(rs.getInt("id"), rs.getInt("price"), rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void addProduct(String name, int price) {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?, ?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.setInt(2, price);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateProductById(Product product) {
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
	public void deleteProductByNameAndId(String name, int id) {
		String sql = "DELETE FROM public.\"Product\" WHERE name = ? AND id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
