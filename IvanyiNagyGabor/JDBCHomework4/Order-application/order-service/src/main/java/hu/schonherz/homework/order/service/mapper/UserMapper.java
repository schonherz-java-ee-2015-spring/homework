package hu.schonherz.homework.order.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.order.dto.User;
import hu.schonherz.homework.order.vo.UserVo;

public class UserMapper {
	
	private static Mapper mapper = new DozerBeanMapper();

	/**
	 * Convert User to UserVo
	 */
	public static UserVo toVo(User user) {
		return mapper.map(user, UserVo.class);
	}
	
	/**
	 * Convert Uservo to User
	 */
	public static User toDto(UserVo userVo) {
		return mapper.map(userVo, User.class);
	}

	/**
	 * Convert User list to UserVo list
	 */
	public static List<UserVo> toVo(List<User> users) {
		List<UserVo> userVos = new ArrayList<UserVo>();
		for (User user : users) {
			userVos.add(toVo(user));
		}
		return userVos;
	}

	/**
	 * Convert UserVo list to User list
	 */
	public static List<User> toDto(List<UserVo> userVos) {
		List<User> users = new ArrayList<User>();
		for (UserVo userVo : userVos) {
			users.add(toDto(userVo));
		}
		return users;
	}
}
