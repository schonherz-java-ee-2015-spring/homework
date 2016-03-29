package hu.schonherz.homework.webshop.service.mapper;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.webshop.dto.User;
import hu.schonherz.homework.webshop.vo.UserVo;

public class UserMapper {

	public static UserVo toVo(User user){
		UserVo vo = new UserVo();
		vo.setId(user.getId());
		vo.setName(user.getName());
		return vo;
	}
	
	public static List<UserVo> toVo(List<User> users) {
		List<UserVo> vos = new ArrayList<>();
		for (User user : users) {
			vos.add(toVo(user) );
		}
		return vos;
	}
	
	public static User toDto(UserVo vo){
		User user = new User();
		user.setId(vo.getId());
		user.setName(vo.getName());
		return user;
	}
	
	public static List<User> toDto(List<UserVo> vos) {
		List<User> users = new ArrayList<>();
		for (UserVo vo : vos) {
			users.add(toDto(vo));
		}
		return users;
	}
}
