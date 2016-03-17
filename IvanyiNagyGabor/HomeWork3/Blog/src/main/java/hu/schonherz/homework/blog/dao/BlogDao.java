package hu.schonherz.homework.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hu.schonherz.homework.blog.model.Blog;

/**
 * @author gabichelsea
 *
 */
public class BlogDao {
	
	private BlogDao() {}

	private static Map<Long, Blog> blogs = new HashMap<Long, Blog>();
	
	private static long currentBlogId = 1;
	
	
	public static void addBlog(Blog blog) {
		blog.setId(currentBlogId);
		blogs.put(blog.getId(), blog);
		currentBlogId += 1;
	}
	
	
	public static Blog findById(Long id) {
		return blogs.get(id);
	}
	
	public static List<Blog> findAll() {
		return blogs.values().stream().collect(Collectors.toList());
	}
	
	
}
