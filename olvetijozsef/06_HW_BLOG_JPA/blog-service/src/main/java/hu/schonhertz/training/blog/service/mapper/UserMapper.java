package hu.schonhertz.training.blog.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonhertz.training.blog.entity.User;
import hu.schonhertz.training.blog.vo.UserNameVo;
import hu.schonhertz.training.blog.vo.UserVo;

public class UserMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static UserVo toVo(User userDto) {
		if (userDto == null) {
			return null;
		}
		return mapper.map(userDto, UserVo.class);
	}

	public static User toDto(UserVo userVo) {
		if (userVo == null) {
			return null;
		}
		return mapper.map(userVo, User.class);
	}

	public static List<UserVo> toVo(List<User> userDtos) {
		List<UserVo> userVos = new ArrayList<>();
		for (User userDto : userDtos) {
			userVos.add(toVo(userDto));
		}
		return userVos;
	}

	public static List<User> toDto(List<UserVo> userVos) {
		List<User> userDtos = new ArrayList<>();
		for (UserVo userVo : userVos) {
			userDtos.add(toDto(userVo));
		}
		return userDtos;
	}

	public static List<UserNameVo> toNameVo(List<User> userDtos) {
		List<UserNameVo> userVos = new ArrayList<>();
		for (User userDto : userDtos) {
			userVos.add(toNameVo(userDto));
		}
		return userVos;
	}

	private static UserNameVo toNameVo(User userDto) {
		if (userDto == null) {
			return null;
		}
		return mapper.map(userDto, UserNameVo.class);
	}

}
