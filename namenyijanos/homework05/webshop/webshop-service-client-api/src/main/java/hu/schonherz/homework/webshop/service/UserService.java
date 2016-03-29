package hu.schonherz.homework.webshop.service;

import java.util.List;

import hu.schonherz.homework.webshop.vo.UserVo;

public interface UserService {

	List<UserVo> getAllUsers();
	
	void addUser(UserVo user);
}
