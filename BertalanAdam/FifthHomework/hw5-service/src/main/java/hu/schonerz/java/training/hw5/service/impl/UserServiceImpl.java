package hu.schonerz.java.training.hw5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.schonerz.java.training.hw5.service.UserService;
import hu.schonerz.java.training.hw5.service.mapper.UserMapper;
import hu.schonerz.java.training.hw5.vo.UserVo;
import hu.schonherz.java.training.hw5.dao.UserDao;
import hu.schonherz.java.training.hw5.dto.User;

//Tells spring that this class is a service class.
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
		User user_loc = UserMapper.toDto(user);
		userDao.addUser(user_loc);
	}

}
