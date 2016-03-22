package hu.schonherz.homework.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.order.dao.ProductDao;
import hu.schonherz.homework.order.dto.Product;
import hu.schonherz.homework.order.dto.User;

public class ProductDaoImpl implements ProductDao {

	private static Connection connection = null;

	public ProductDaoImpl(Connection connection) {
		ProductDaoImpl.connection = connection;
	}

	@Override
	public List<Product> getAllProducts() {
		String sql = "SELECT id, name, price FROM public.\"Product\";";
		List<Product> products = new ArrayList<Product>();
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(sql);) {
			while (resultSet.next()) {
				products.add(
						new Product(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("price")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	@Override
	public Product getProductById(Integer id) {
		String sql = "SELECT id, name, price FROM public.\"Product\" WHERE id = ?;";
		Product product = null;
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				if (resultSet.next()) {
					product = new Product(resultSet.getInt("id"), resultSet.getString("name"),
							resultSet.getInt("price"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public void addProduct(Product product) {
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?, ?);";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, product.getName());
			statement.setInt(2, product.getPrice());
			statement.executeUpdate();
			try (ResultSet resultSet = statement.getGeneratedKeys();) {
				if (resultSet.next()) {
					product.setId(resultSet.getInt("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateProduct(Product product) {
		String sql = "UPDATE public.\"Product\" SET name=?, price = ? WHERE id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, product.getName());
			statement.setInt(2, product.getPrice());
			statement.setInt(3, product.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(Product product) {
		String sql = "DELETE FROM public.\"Product\" WHERE id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, product.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
