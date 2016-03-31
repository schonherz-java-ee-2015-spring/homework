package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.RoleVo;

public interface RoleService {

	public List<RoleVo> getAllRole() throws Exception;
	
	public void removeAllRoleByUserId(Long userId) throws Exception;
}
