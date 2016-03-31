package hu.schonherz.java.training.jdbc.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.java.training.jdbc.core.records.User;
import hu.schonherz.java.training.jdbc.service.vo.UserVo;

public class UserMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public UserMapper() {
		super();
	}

	public static UserVo toVo(User user) {
		return mapper.map(user, UserVo.class);
	}

	public static User toDto(UserVo userVo) {
		return mapper.map(userVo, User.class);
	}

	public static List<UserVo> toVo(List<User> users) {
		List<UserVo> userVos = new ArrayList<>();
		for (User user : users) {
			userVos.add(toVo(user));
		}
		return userVos;
	}

	public static List<User> toDto(List<UserVo> userVos) {
		List<User> users = new ArrayList<>();
		for (UserVo userVo : userVos) {
			users.add(toDto(userVo));
		}
		return users;
	}

}
