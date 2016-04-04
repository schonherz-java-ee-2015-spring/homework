package hu.schonherz.atka.jdbchomework.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.atka.jdbchomework.connection.ConnectionHandler;
import hu.schonherz.atka.jdbchomework.pojo.Product;

public class ProductDaoImpl implements Dao<Product> {

	private Connection connection;

	public ProductDaoImpl() {
		try {
			connection = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while building connection!");
		}
	}

	public void addElement(Product product) {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?,?) ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getPrice());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while adding product!");
		}
	}

	public void updateElement(Product product) {
		String sql = "UPDATE public.\"Product\" SET name = ? , price = ? WHERE id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, product.getName());
			stmt.setInt(2, product.getPrice());
			stmt.setInt(3, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while updating product!");
		}
	}

	public void deleteElement(Product product) {
		String sql = "DELETE FROM public.\"Product\" WHERE id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, product.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while deleting product!");
		}
	}
	
	// Task 2.c
	public List<Product> selectProductsByCallableStatement() {
		String sql = "{call \"select_products\"()}";
		List<Product> result = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					result.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while selecting products!");
		}
		return result;
	}
}
