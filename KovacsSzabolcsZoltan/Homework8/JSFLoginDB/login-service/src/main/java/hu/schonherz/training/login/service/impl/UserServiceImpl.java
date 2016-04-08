package hu.schonherz.training.login.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.login.service.UserService;
import hu.schonhertz.training.login.vo.UserVo;
import hu.schonherz.training.entity.User;
import hu.schonherz.training.login.service.mapper.UserMapper;
import hu.schonherz.training.repository.UserRepository;


@Service("userService")
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	public UserServiceImpl() {
	}

	@Override
	public UserVo findUserByName(String name) throws Exception {
		UserVo vo = UserMapper.toVo(userRepository.findUserByUserName(name));
		return vo;
	}

	@Override
	public void registrationUser(UserVo userVO) throws Exception {
		if (userVO.getEmailAddress() == null) {
			userVO.setUserType("guest");
		} else {
			userVO.setUserType("normal");
		}
		@SuppressWarnings("unused")
		User user = userRepository.saveAndFlush(UserMapper.toDto(userVO));
	}

	@Override
	public List<String> getAllName() {
		List<User> users = userRepository.findAll();
		List<String> names = new ArrayList<>();
		for (User user : users) {
			names.add(user.getUserName());		
		}
		return names;
	}



}
