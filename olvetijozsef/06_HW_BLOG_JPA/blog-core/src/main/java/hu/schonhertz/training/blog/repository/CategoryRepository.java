package hu.schonhertz.training.blog.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.entity.Category;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface CategoryRepository extends JpaRepository<Category, Long> {

	List<Category> findByNameStartingWithIgnoreCase(String term);

	Category findByName(String name);

}
