package hu.schonerz.java.training.hw5.service.mapper;

import java.util.ArrayList;
import java.util.List;

import hu.schonerz.java.training.hw5.vo.UserVo;
import hu.schonherz.java.training.hw5.dto.User;

// Convert DTO to VO and vice versa.
public class UserMapper {
	
	public static UserVo toVo( User user ){
		UserVo uvo = new UserVo();
		uvo.setId(user.getId());
		uvo.setName(user.getName());
		return uvo;
	}
	
	public static List<UserVo> toVo(List<User> users) {
		List<UserVo> uvos = new ArrayList<>();
		for (User user : users) {
			uvos.add( toVo(user) );
		}
		return uvos;
	}
	
	public static User toDto( UserVo user ){
		User u = new User();
//		u.setId(user.getId());
		u.setName(user.getName());
		return u;
	}
	
	public static List<User> toDto(List<UserVo> uvos) {
		List<User> users = new ArrayList<>();
		for (UserVo uvo : uvos) {
			users.add(toDto(uvo));
		}
		return users;
	}

}
