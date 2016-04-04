package hu.schonhertz.training.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.repository.RoleRepository;
import hu.schonhertz.training.blog.service.RoleService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleRepository roleRepository;


	@Override
	public void removeAllRoleByUserId(Long userId) throws Exception {
		roleRepository.removeAllRoleByUserId(userId);
	}
	
	
}
