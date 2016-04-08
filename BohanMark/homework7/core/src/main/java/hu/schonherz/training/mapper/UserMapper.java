package hu.schonherz.training.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.training.homework7.pojo.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		
		user.setId(rs.getInt("id"));
		user.setEmail(rs.getString("email"));
		user.setUsername(rs.getString("username"));
		user.setUserType(rs.getString("usertype"));
		user.setPassword(null);
		return user;
	}

}
