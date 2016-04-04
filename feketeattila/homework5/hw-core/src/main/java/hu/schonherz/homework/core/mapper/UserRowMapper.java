package hu.schonherz.homework.core.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.core.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto> {

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new UserDto(rs.getLong("id"), rs.getString("name"));
	}

}
