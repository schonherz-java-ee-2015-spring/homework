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
import hu.schonherz.training.hw.jdbc.dao.UserDAO;
import hu.schonherz.training.hw.jdbc.entity.User;

public class UserDAOImpl implements UserDAO {
	private Connection con;

	public UserDAOImpl() {
		try {
			con = ConnectionManager.getPostgreConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, user.getName());
			stmt.execute();
			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				int userId = rs.getInt("id");
				user.setId(userId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE public.\"User\" SET name = ? WHERE id = ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, user.getName());
			stmt.setInt(2, user.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		String sql = "DELETE FROM public.\"User\" WHERE id = ?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, user.getId());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?";
		User user = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					user = new User(rs.getInt("id"), rs.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "{call \"getUsers\"()}";
		List<User> users = new ArrayList<User>();
		try (CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					users.add(new User(rs.getInt("id"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
