package hu.schonherz.homework.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.jdbc.ConnectionHandler;
import hu.schonherz.homework.records.User;


public class UserDaoImpl implements UserDao{
	private Connection con;

	public UserDaoImpl() {
		try {
			con = ConnectionHandler.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> getAllUser() {
		String sql = "SELECT id, name FROM public.\"User\"";
		List<User> user = new ArrayList<>();
		try (Statement stmt = con.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(sql);) {
				while (rs.next()) {
					user.add(new User(rs.getInt("id"), rs.getString("name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}


	@Override
	public void updateUserNameById(String name, int id) {
		String sql = "UPDATE public.\"User\" SET name=? WHERE public.\"User\".id = ?";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUserByIdAndName(User user) {
		String sql = "DELETE FROM public.\"User\" WHERE public.\"User\".id = ? AND public.\"User\".name= ? ;";
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, user.getId());
			stmt.setString(2, user.getName());
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addUser(String name) {
		String sql = "INSERT INTO public.\"User\" (name) VALUES (?) ;";
		try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			stmt.setString(1, name);
			stmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
