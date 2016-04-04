package hu.schonhertz.training.blog.service;

import java.util.List;

import hu.schonhertz.training.blog.vo.RoleVo;

public interface RoleService {

	List<RoleVo> getAllRoles();

	void addRoles(Long roleId, Long userId) throws Exception;

	void removeRoles(Long roleId, Long userId);

	RoleVo getRoleByName(String string) throws Exception;

	void removeAllRoles(Long userId);
}
