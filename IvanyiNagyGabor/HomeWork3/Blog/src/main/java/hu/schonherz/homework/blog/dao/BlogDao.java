package hu.schonherz.homework.blog.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import hu.schonherz.homework.blog.model.Blog;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public class BlogDao {

	/**
	 * Private constructor would exist to prevent the class from being instantiated
	 */
	private BlogDao() {
	}

	private static Map<Long, Blog> blogs = new HashMap<Long, Blog>();

	private static long currentBlogId = 1;

	
	/**
	 * Add new blog to the map
	 * @param blog is the blog that you want to add to the map
	 */
	public static void addBlog(Blog blog) {
		blog.setId(currentBlogId);
		blogs.put(blog.getId(), blog);
		currentBlogId += 1;
	}

	/**
	 * Find a blog according to id
	 * @param id which blog you want
	 * @return the blog that contains the id
	 */
	public static Blog findById(Long id) {
		return blogs.get(id);
	}

	
	/**
	 * Find all blogs 
	 * @return all blogs
	 */
	public static List<Blog> findAll() {
		return blogs.values().stream().collect(Collectors.toList());
	}

}
