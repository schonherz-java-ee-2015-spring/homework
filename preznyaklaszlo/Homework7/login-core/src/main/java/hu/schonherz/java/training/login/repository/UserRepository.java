package hu.schonherz.java.training.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonherz.java.training.login.entity.User;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface UserRepository extends JpaRepository<User, Long> {

	User findUserByUserName(String name) throws Exception;

	User findUserByEmail(String email) throws Exception;

}
