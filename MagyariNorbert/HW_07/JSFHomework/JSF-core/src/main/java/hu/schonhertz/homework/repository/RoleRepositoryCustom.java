package hu.schonhertz.homework.repository;

public interface RoleRepositoryCustom {

	void removeRoleFromUser(Long roleId, Long userId) throws Exception;

}
