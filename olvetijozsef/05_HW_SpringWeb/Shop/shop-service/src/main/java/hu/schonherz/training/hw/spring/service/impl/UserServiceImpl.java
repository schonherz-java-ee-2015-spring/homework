package hu.schonherz.training.hw.spring.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.training.hw.spring.dao.UserDAO;
import hu.schonherz.training.hw.spring.service.UserService;
import hu.schonherz.training.hw.spring.service.mapper.UserMapper;
import hu.schonherz.training.hw.spring.vo.UserVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(UserVo user) {
		userDAO.addUser(user.getName());
	}

	@Override
	public void updateUser(UserVo user) {
		userDAO.updateUser(UserMapper.toDto(user));
	}

	@Override
	public void deleteUser(UserVo user) {
		userDAO.deleteUser(user.getId());
	}

	@Override
	public UserVo getUserById(Integer id) {
		return UserMapper.toVo(userDAO.getUserById(id));
	}

	@Override
	public List<UserVo> getAllUsers() {
		return UserMapper.toVo(userDAO.getAllUsers());
	}

}
