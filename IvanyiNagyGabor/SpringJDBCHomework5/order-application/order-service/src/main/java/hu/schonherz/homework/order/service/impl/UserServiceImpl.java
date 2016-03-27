package hu.schonherz.homework.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.homework.order.dao.UserDao;
import hu.schonherz.homework.order.service.UserService;
import hu.schonherz.homework.order.service.mapper.UserMapper;
import hu.schonherz.homework.order.vo.UserVo;


@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserVo> getAllUser() throws Exception {
		return UserMapper.toVo(userDao.findAll());
	}

	@Override
	public void addUser(UserVo userVo) throws Exception {
		userDao.save(UserMapper.toDto(userVo));	
	}
	
	
}
