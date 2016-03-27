package hu.schonherz.training.homework4.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.homework4.connection.DBConnection;
import hu.schonherz.training.homework4.dao.ProductDao;
import hu.schonherz.training.homework4.dto.Product;

/**
 * Postgresql JDBC implementation of ProductDao
 * 
 * @author Mark Bohan
 *
 */
public class ProductDaoImpl implements ProductDao {

	private Connection connection;

	@SuppressWarnings("javadoc")
	public ProductDaoImpl() {
		super();
		try {
			this.connection = DBConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Product findProductById(Integer id) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?";
		Product product = new Product();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getInt("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public Product findProductByName(String name) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE name = ?";
		Product product = new Product();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					product.setId(rs.getInt("id"));
					product.setName(rs.getString("name"));
					product.setPrice(rs.getInt("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "{call public.\"getProducts\"() }";
		List<Product> Products = new ArrayList<Product>();
		try (CallableStatement cstmt = connection.prepareCall(sql)) {
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				Product product = new Product();
				product.setId(rs.getInt("id"));
				product.setName(rs.getString("name"));
				product.setPrice(rs.getInt("price"));
				Products.add(product);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Products;
	}

	@Override
	public void createProduct(Product product) {
		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES ( ? , ? );";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, product.getName());
			pstmt.setInt(2, product.getPrice());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
