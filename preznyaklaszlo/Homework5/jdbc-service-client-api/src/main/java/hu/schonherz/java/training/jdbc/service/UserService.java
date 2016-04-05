package hu.schonherz.java.training.jdbc.service;

import java.util.List;

import hu.schonherz.java.training.jdbc.service.vo.UserVo;

public interface UserService {
	public List<UserVo> getAllUsers();

	public void addUser(UserVo user);

}
