package hu.schonherz.homework.headswitcher.user;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.headswitcher.connection.BurnedInHandler;

public class UserDaoImpl implements UserDao {

	private Connection con;

	public UserDaoImpl() {
		try {
			con = BurnedInHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//writing impl. for every method using Statements, and Prepared statements

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT id, name FROM public.\"User\";";
		List<User> list = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new User(rs.getInt("id"), rs.getString("name")));
			}
		}

		catch (SQLException e) {
			System.out.println("Something went wrong! :(");
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public User getUserById(int id) {
		String sql = "SELECT id, name  FROM public.\"User\"  where id = ?;";
		User usr = null;
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			try {
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					usr = new User(rs.getInt("id"), rs.getString("name"));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Something went wrong! :c");
		}
		return usr;
	}

	@Override
	public void addUser(String name) { // adding the id is the Database's job
										// (id with serial type)

		String sql = "INSERT INTO public.\"User\"(name) VALUES (?);";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.executeUpdate();
			System.out.println("One User inserted!");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Insert failed");
		}

	}

	@Override
	public void deleteUserById(int id) {
		String sql = "DELETE FROM public.\"User\" WHERE id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.execute();
			System.out.println("User with id: " + id + " deleted");

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Delete failed , (probobly the User is still referenced from table \"Order\")");
		}
	}

	@Override
	public void updateUserName(int id, String name) {
		String sql = "UPDATE public.\"User\" SET name=? WHERE id=?;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			System.out.println("Update succeeded");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Update failed");
		}

	}

	@Override
	public void getAllUserByCall() {
		String sql = "{call \"getAllUser\"()}";
		List<User> users = new ArrayList<>();
		try (Connection con = BurnedInHandler.getConnection(); CallableStatement stmt = con.prepareCall(sql)) {
			try (ResultSet rs = stmt.executeQuery();) {
				while (rs.next()) {
					users.add(new User(rs.getInt("id"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("--- CallableStatement Result ---\n");

		for (User user : users) {
			System.out.println("ID: " + user.getId() + " Name: " + user.getName());
		}
	}

}
