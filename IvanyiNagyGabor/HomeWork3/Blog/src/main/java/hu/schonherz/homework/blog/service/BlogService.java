package hu.schonherz.homework.blog.service;

import java.util.List;

import hu.schonherz.homework.blog.model.Blog;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public interface BlogService {
	
	// Create blog
	// return true if the creating was succesful else false
	boolean createBlog(Blog blog);
	
	// Get blog by Id
	Blog getBlogById(Long id);
	
	// get All blogs
	List<Blog> getAllBlogs();
	
	
}
