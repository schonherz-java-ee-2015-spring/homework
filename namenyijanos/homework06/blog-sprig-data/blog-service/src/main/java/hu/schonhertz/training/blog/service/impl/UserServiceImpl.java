package hu.schonhertz.training.blog.service.impl;

import java.util.List;

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
import hu.schonhertz.training.blog.vo.RoleVo;
import hu.schonhertz.training.blog.vo.UserVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
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
	public void registrationUser(UserVo userVo) throws Exception {
		User user = userRepository.saveAndFlush(UserMapper.toDto(userVo));
		Role userRole = roleRepository.findRoleByName("ROLE_USER");
		roleRepository.addRoleToUser(userRole.getId(), user.getId());
	}

	@Override
	public UserVo setUpRoles(UserVo vo, List<RoleVo> roles) throws Exception {
		List<Role> rolesLocal;
		try {
			if (roles == null) {
				rolesLocal = roleRepository.findRolesByUserId(vo.getId());
				vo.setRoles(RoleMapper.toVo(rolesLocal));
			} else {
				vo.setRoles(roles);
				userRepository.saveAndFlush(UserMapper.toDto(vo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}

	@Override
	public List<UserVo> getAllUsers() throws Exception {
		List<User> users = null;
		users = userRepository.findAll();
		return UserMapper.toVo(users);
	}

}
