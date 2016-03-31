package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.entity.Role;
import hu.schonhertz.training.blog.entity.User;
import hu.schonhertz.training.blog.repository.RoleRepository;
import hu.schonhertz.training.blog.repository.UserRepository;
import hu.schonhertz.training.blog.service.UserService;
import hu.schonhertz.training.blog.service.mapper.RoleMapper;
import hu.schonhertz.training.blog.service.mapper.UserMapper;
import hu.schonhertz.training.blog.vo.UserVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {

	static final Logger logger = LogManager.getLogger(UserServiceImpl.class.getName());

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;


	public UserServiceImpl() {
	}

	@Override
	public UserVo findUserByName(String name) throws Exception {
		UserVo vo = UserMapper.toVo(userRepository.findUserByUserName(name));
		return vo;
	}

	@Override
	public UserVo setUpRoles(UserVo vo) throws Exception {
		List<Role> roles;
		try {
			roles = roleRepository.findRolesByUserId(vo.getId());
			vo.setRoles(RoleMapper.toVo(roles));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	@Override
	public void registrationUser(UserVo userVo) throws Exception {
		User user = userRepository.saveAndFlush(UserMapper.toDto(userVo));
		Role userRole = roleRepository.findRoleByName("ROLE_USER");
		roleRepository.addRoleToUser(userRole.getId(), user.getId());
	}

	@Override
	public List<UserVo> getAllUser() throws Exception {
		List<User> users = null;
		try {
			users = userRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return UserMapper.toVo(users);
	}

	@Override
	public List<UserVo> getAllUserBySorted() throws Exception {
		List<User> users = null;
		try {
			users = userRepository.findAllByOrderByUserNameAsc();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return UserMapper.toVo(users);
	}

	@Override
	public void addRolesToUser(UserVo userVo) throws Exception {
		User user = UserMapper.toDto(userVo);
		List<Role> roles = RoleMapper.toDto(userVo.getRoles());
				
		for (Role role : roles) {
			roleRepository.addRoleToUser(role.getId(), user.getId());
		}
		
	}


}
