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
import hu.schonherz.atka.jdbchomework.pojo.User;

public class UserDaoImpl implements Dao<User> {

	private Connection connection;

	public UserDaoImpl() {
		try {
			connection = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while building connection!");
		}
	}

	public void addElement(User user) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?) ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getName());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while adding user!");
		}
	}

	public void updateElement(User user) {
		String sql = "UPDATE public.\"User\" SET name = ? WHERE id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while updating user!");
		}
	}

	public void deleteElement(User user) {
		String sql = "DELETE FROM public.\"User\" WHERE id = ? ;";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, user.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while deleting user!");
		}
	}

	// Task 2.b
	public List<User> selectUsersByCallableStatement() {
		String sql = "{call \"select_users\"()}";
		List<User> result = new ArrayList<>();
		try (CallableStatement stmt = connection.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					result.add(new User(rs.getInt("id"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("ERROR: Exception while selecting products!");
		}
		return result;
	}
}
