package hu.schonherz.homework.headswitcher.product;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.headswitcher.connection.BurnedInHandler;

public class ProductDaoImpl implements ProductDao {

	private Connection con;

	public ProductDaoImpl() {

		try {
			con = BurnedInHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// writing impl. for every method using Statements, and Prepared statements
	@Override
	public List<Product> getAllProduct() {
		String sql = "SELECT id, name , price FROM public.\"Product\";";
		List<Product> list = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price")));
			}
		}

		catch (SQLException e) {
			System.out.println("Something went wrong! :(");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Product getProductById(int id) {
		String sql = "SELECT id, name , price  FROM public.\"Product\"  where id = ?;";
		Product product = null;

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return product;
	}

	@Override
	public Product getProductByName(String name) {

		String sql = "SELECT id, name , price  FROM public.\"Product\"  where name = ?;";
		Product product = null;

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					product = new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return product;
	}

	@Override
	public void addProduct(String name, int price) {

		String sql = "INSERT INTO public.\"Product\"(name, price) VALUES (?, ?);";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.setInt(2, price);
			stmt.executeUpdate();
			System.out.println("One Product inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert failed");
		}

	}

	@Override
	public void addProduct(String name) {
		String sql = "INSERT INTO public.\"Product\"(name) VALUES (?);";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.executeUpdate();
			System.out.println("One Product inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert failed");
		}

	}

	@Override
	public void deleteProductById(int id) {
		String sql = "DELETE FROM public.\"Product\" WHERE id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("Product with id: " + id + " deleted");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed , (probobly the Product is still referenced from table \"Order\")");
		}
	}

	@Override
	public void updateProductName(int id, String newName) {

		String sql = "UPDATE public.\"Product\" SET name=? WHERE id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, newName);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Update succeeded");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
		}
	}

	@Override
	public void updateProductPrice(int id, int newPrice) {

		// String sql = "UPDATE public.\"Product\" SET price=? WHERE id=?;";
		// try (PreparedStatement stmt = con.prepareStatement(sql,
		// Statement.RETURN_GENERATED_KEYS)) {
		// stmt.setInt(1, newPrice);
		// stmt.setInt(2, id);
		// stmt.executeUpdate();
		// System.out.println("Update succeeded");
		// } catch (SQLException e) {
		// e.printStackTrace();
		// System.out.println("Update failed");
		// }
	}

	@Override
	public void getProductsByCall() {
		String sql = "{call \"getAllProduct\"()}";
		List<Product> product = new ArrayList<>();
		try (Connection con = BurnedInHandler.getConnection(); CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					product.add(new Product(rs.getInt("id"), rs.getString("name"), rs.getInt("price")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("--- CallableStatement Result ---\n");

		for (Product products : product) {
			System.out.println(
					"ID: " + products.getId() + " Name: " + products.getName() + " Price: " + products.getPrice());
		}
	}

}
