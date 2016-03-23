package hu.schonherz.homework.order.dao.impl;

import java.sql.CallableStatement;
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
		// String sql = "SELECT id, name, price FROM public.\"Product\";";
		String sql = "{call \"getAllProduct\"()}";
		List<Product> products = new ArrayList<Product>();
		try (CallableStatement statement = connection.prepareCall(sql);
				ResultSet resultSet = statement.executeQuery();) {
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

	@Override
	public void addProductsWithBatchSize(Integer batchSize, Product... products) {
		int count = 0;
		String sql = "INSERT INTO public.\"Product\" (name, price) VALUES (?, ?);";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Product product : products) {
				statement.setString(1, product.getName());
				statement.setInt(2, product.getPrice());
				statement.addBatch();
				if (++count % batchSize == 0) {
					statement.executeBatch();
				}
			}
			statement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteProductsWithBatchSize(Integer batchSize, Product... products) {
		int count = 0;
		String sql = "DELETE FROM public.\"Product\" WHERE id=? and name=? and price=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			connection.setAutoCommit(false);
			for (Product product : products) {
				statement.setInt(1, product.getId());
				statement.setString(2, product.getName());
				statement.setInt(3, product.getPrice());
				statement.addBatch();
				if (++count % batchSize == 0) {
					statement.executeBatch();
				}
			}
			statement.executeBatch();
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
