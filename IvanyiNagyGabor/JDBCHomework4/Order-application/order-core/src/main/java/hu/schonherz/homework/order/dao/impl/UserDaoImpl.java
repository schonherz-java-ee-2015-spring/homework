package hu.schonherz.homework.order.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.order.dao.UserDao;
import hu.schonherz.homework.order.dto.User;

public class UserDaoImpl implements UserDao {

	private static Connection connection = null;

	public UserDaoImpl(Connection connection) {
		UserDaoImpl.connection = connection;
	}

	/**
	 * Return the all User from the User table
	 */
	@Override
	public List<User> getAllUser() {
		String sql = "{call \"getAllUser\"()}";
		List<User> users = new ArrayList<User>();
		try (CallableStatement statement = connection.prepareCall(sql);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt("id"), resultSet.getString("name")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	/**
	 * Return the all User from the User table where (user)id = id
	 */
	@Override
	public User getUserById(Integer id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?;";
		User user = null;
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				if (resultSet.next()) {
					user = new User(resultSet.getInt("id"), resultSet.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * Insert a new User into the User table
	 */
	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?);";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
			statement.setString(1, user.getName());
			statement.executeUpdate();
			try (ResultSet resultSet = statement.getGeneratedKeys();) {
				if (resultSet.next()) {
					user.setId(resultSet.getInt("id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Update User in the User table where user(id) = id
	 */
	@Override
	public void updateUser(User user) {
		String sql = "UPDATE public.\"User\" SET name=? WHERE id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, user.getName());
			statement.setInt(2, user.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Delete a User from the User table
	 */
	@Override
	public void deleteUser(User user) {
		String sql = "DELETE FROM public.\"User\" WHERE id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, user.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
