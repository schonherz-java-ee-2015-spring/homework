package hu.schonherz.homework.order.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import hu.schonherz.homework.order.dto.UserDto;

public class UserRowMapper implements RowMapper<UserDto> {

	
	// Set and return the userDto from the resultSet
	public UserDto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
		userDto.setId(resultSet.getLong("id"));
		userDto.setName(resultSet.getString("name"));
		return userDto;
	}

	
}
