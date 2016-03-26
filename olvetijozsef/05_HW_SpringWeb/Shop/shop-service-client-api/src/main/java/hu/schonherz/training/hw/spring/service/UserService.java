package hu.schonherz.training.hw.spring.service;

import java.util.List;

import hu.schonherz.training.hw.spring.vo.UserVo;

public interface UserService {

	void addUser(UserVo user);

	void updateUser(UserVo user);

	void deleteUser(UserVo user);

	UserVo getUserById(Integer id);

	List<UserVo> getAllUsers();
}
