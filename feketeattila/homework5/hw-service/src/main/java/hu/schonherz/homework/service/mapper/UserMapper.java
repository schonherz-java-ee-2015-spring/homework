package hu.schonherz.homework.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.schonherz.homework.core.dto.UserDto;
import hu.schonherz.homework.service.vo.UserVo;

public class UserMapper {

	private static Mapper mapper = new DozerBeanMapper();

	public static UserVo toVo(UserDto user) {
		return mapper.map(user, UserVo.class);
	}

	public static UserDto toDto(UserVo userVo) {
		return mapper.map(userVo, UserDto.class);
	}

	public static List<UserVo> toVo(List<UserDto> users) {
		List<UserVo> userVos = new ArrayList<>();
		for (UserDto user : users) {
			userVos.add(toVo(user));
		}
		return userVos;
	}

	public static List<UserDto> toDto(List<UserVo> userVos) {
		List<UserDto> users = new ArrayList<>();
		for (UserVo userVo : userVos) {
			users.add(toDto(userVo));
		}
		return users;
	}

}