package hu.schonherz.homework.blog.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.blog.core.entitiy.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User(rs.getInt("id"), rs.getString("name"));
		return user;
	}

}
