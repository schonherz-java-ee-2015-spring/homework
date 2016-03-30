package hu.schonherz.java.training.jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.java.training.jdbc.records.User;

public class UserMapper implements RowMapper<User> {

	public UserMapper() {
		super();
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(rs.getInt("id"), rs.getString("name"));
		return user;
	}

}
