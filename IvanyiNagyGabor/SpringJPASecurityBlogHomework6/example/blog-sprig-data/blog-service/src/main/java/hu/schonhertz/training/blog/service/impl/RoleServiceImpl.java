package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.entity.Role;
import hu.schonhertz.training.blog.repository.RoleRepository;
import hu.schonhertz.training.blog.service.RoleService;
import hu.schonhertz.training.blog.service.mapper.RoleMapper;
import hu.schonhertz.training.blog.vo.RoleVo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public List<RoleVo> getAllRole() throws Exception {
		List<Role> rollList = roleRepository.findAll();
		return RoleMapper.toVo(rollList);
	}

	@Override
	public void removeAllRoleByUserId(Long userId) throws Exception {
		roleRepository.removeAllRoleByUserId(userId);
	}
	
	
}
