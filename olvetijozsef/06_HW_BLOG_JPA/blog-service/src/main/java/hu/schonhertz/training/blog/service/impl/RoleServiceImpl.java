package hu.schonhertz.training.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	public List<RoleVo> getAllRoles() {
		return RoleMapper.toVo(roleRepository.findAll());
	}

	@Override
	public void addRoles(Long roleId, Long userId) throws Exception {
		roleRepository.addRoleToUser(roleId, userId);
	}

	@Override
	public void removeRoles(Long roleId, Long userId) {
		try {
			roleRepository.removeRoleFromUser(roleId, userId);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public RoleVo getRoleByName(String name) throws Exception {
		return RoleMapper.toVo(roleRepository.findRoleByName(name));
	}

	@Override
	public void removeAllRoles(Long userId) {
		roleRepository.removeAllRoleFromUser(userId);
	}

}
