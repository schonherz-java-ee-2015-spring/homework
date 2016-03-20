package hu.schonherz.homework.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.jdbc.connection.SqlConnectionHandlerFactory;
import hu.schonherz.homework.jdbc.model.User;

/**
 * @author gabichelsea
 *
 */
public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl() {
		initConnection();
	}

	private void initConnection() {

		try {
			connection = SqlConnectionHandlerFactory.getSqlConnectionHandler("POSTGRESQL").getSqlConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> users = new ArrayList<User>();
		try (Statement statement = connection.createStatement(); ResultSet set = statement.executeQuery(sql)) {
			while (set.next()) {
				users.add(new User(set.getInt("id"), set.getString("name")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT id, name FROM public.\"User\" WHERE id = ?;";
		User user = null;
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, id);
			try (ResultSet set = statement.executeQuery();) {
				while (set.next()) {
					user = new User(set.getInt("id"), set.getString("name"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User user) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?);";
		try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			statement.setString(1, user.getName());
			statement.execute();
			ResultSet set = statement.getGeneratedKeys();
			while (set.next()) {
				int id = set.getInt("id");
				user.setId(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateUser(User user) {
		String sql = "UPDATE public.\"User\" SET name=? WHERE id=?;";
		try (PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, user.getName());
			statement.setInt(2, user.getId());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User user) {
		String sql = "DELETE FROM public.\"User\" WHERE id = ? and name = ? ;";
		try (PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, user.getId());
			statement.setString(2, user.getName());
			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
