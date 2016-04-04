package hu.schonhertz.training.blog.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.schonhertz.training.blog.entity.Blog;
import hu.schonhertz.training.blog.entity.Category;

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface BlogRepository extends JpaRepository<Blog, Long> {

	Page<Blog> findByTitleContainingIgnoreCase(String title, Pageable pageable);

	Page<Blog> findByCategory(Category category, Pageable pageable);

}
