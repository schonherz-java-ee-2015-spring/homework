package hu.schonherz.homework.blog.service;

import java.util.List;

import hu.schonherz.homework.blog.model.Blog;

/**
 * @author gabichelsea
 *
 */
public interface BlogService {
	
	void createBlog(Blog blog);
	Blog getBlogById(Long id);
	List<Blog> getAllBlogs();
	
	
}
