package hu.schonherz.homework.webshop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import hu.schonherz.homework.webshop.dao.UserDao;
import hu.schonherz.homework.webshop.dto.User;
import hu.schonherz.homework.webshop.service.UserService;
import hu.schonherz.homework.webshop.service.mapper.UserMapper;
import hu.schonherz.homework.webshop.vo.UserVo;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserVo> getAllUsers() {
		List<User> users = userDao.getAllUsers();
		return UserMapper.toVo(users);
	}

	@Override
	public void addUser(UserVo user) {
		User u = UserMapper.toDto(user);
		userDao.addUser(u);
	}

}
