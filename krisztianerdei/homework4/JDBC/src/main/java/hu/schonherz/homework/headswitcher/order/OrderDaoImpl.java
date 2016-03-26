package hu.schonherz.homework.headswitcher.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.headswitcher.connection.BurnedInHandler;

public class OrderDaoImpl implements OrderDao {

	private Connection con;

	public OrderDaoImpl() {
		// getting connection for the db
		try {
			con = BurnedInHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// writing impl. for every method using Statements, and Prepared statements

	@Override
	public List<Order> getAllProduct() {
		String sql = "SELECT user_id, product_id FROM public.\"Order\";";
		List<Order> list = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Order(rs.getInt("user_id"), rs.getInt("product_id")));
			}
		}

		catch (SQLException e) {
			System.out.println("Something went wrong! :(");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public Order getOrderByUser_Id(int userId) {
		String sql = "SELECT user_id, product_id  FROM public.\"Order\"  where user_id = ?;";
		Order order = null;

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userId);
			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					order = new Order(rs.getInt("user_id"), rs.getInt("product_id"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return order;
	}

	@Override
	public Order getOrderByProduct_Id(int productId) {
		String sql = "SELECT user_id, product_id  FROM public.\"Order\"  where product_id = ?;";
		Order order = null;

		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, productId);
			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					order = new Order(rs.getInt("user_id"), rs.getInt("product_id"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}

		return order;
	}

	@Override
	public void addOrder(int userid, int productid) {

		String sql = "INSERT INTO public.\"Order\"( user_id, product_id) VALUES (?, ?);";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, userid);
			stmt.setInt(2, productid);
			stmt.executeUpdate();
			System.out.println("One Order inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert failed");
		}

	}

	@Override
	public void deleteOrderByUser_Id(int userid) {

		String sql = "DELETE FROM public.\"Order\" WHERE user_id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, userid);
			stmt.execute();
			System.out.println("Order with id: " + userid + " deleted");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed");
		}
	}

	@Override
	public void deleteOrderByProduct_Id(int productid) {

		String sql = "DELETE FROM public.\"Order\" WHERE product_id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, productid);
			stmt.execute();
			System.out.println("Order with id: " + productid + " deleted");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed");
		}
	}

	@Override
	public void updateUserOrder(int user_Id, int newProductId) {
		String sql = "UPDATE public.\"Order\" SET product_id=? WHERE user_id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setInt(1, newProductId);
			stmt.setInt(2, user_Id);
			stmt.executeUpdate();
			System.out.println("Update succeeded");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
		}
	}

}
