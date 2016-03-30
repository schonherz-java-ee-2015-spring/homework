package hu.schonherz.java.training.jdbc.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.training.jdbc.dao.UserDao;
import hu.schonherz.java.training.jdbc.mapper.UserMapper;
import hu.schonherz.java.training.jdbc.service.UserService;
import hu.schonherz.java.training.jdbc.vo.UserVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserVo> getAllUsers() {
		return UserMapper.toVo(userDao.getAllUsers());
	}

	@Override
	public void addUser(UserVo userVo) {
		userDao.addUser(UserMapper.toDto(userVo));
	}

}
