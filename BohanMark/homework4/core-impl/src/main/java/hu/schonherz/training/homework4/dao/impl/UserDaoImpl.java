package hu.schonherz.training.homework4.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.training.homework4.connection.DBConnection;
import hu.schonherz.training.homework4.dao.UserDao;
import hu.schonherz.training.homework4.dto.User;

/**
 * Postgresql JDBC implementation of UserDao
 * 
 * @author Mark Bohan
 *
 */
public class UserDaoImpl implements UserDao {

	private Connection connection;

	@SuppressWarnings("javadoc")
	public UserDaoImpl() {
		super();
		try {
			this.connection = DBConnection.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public User findUserById(Integer id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?";
		User user = new User();

		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public User findUserByName(String name) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE name = ?";
		User user = new User();
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, name);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public List<User> getAllUsers() {

		String sql = "{call public.\"getUsers\"() }";
		List<User> users = new ArrayList<User>();
		try (CallableStatement cstmt = connection.prepareCall(sql)) {
			ResultSet rs = cstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				users.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}

	public void createUser(User user) {
		String sql = "INSERT INTO public.\"User\"(name) VALUES ( ? );";
		try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
			pstmt.setString(1, user.getName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
