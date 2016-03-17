/**
 * 
 */
package hu.schonherz.homework.blog.service;

import java.util.List;

import hu.schonherz.homework.blog.dao.BlogDao;
import hu.schonherz.homework.blog.model.Blog;

/**
 * @author gabichelsea
 *
 */
public class BlogServiceImpl implements BlogService {

	@Override
	public void createBlog(Blog blog) {
		if (blog.getTitle() != null && blog.getContent() != null) {
			if (BlogDao.findAll().stream()
					.anyMatch(currentBlog -> currentBlog.getTitle().equalsIgnoreCase(blog.getTitle())) == false) {
				BlogDao.addBlog(blog);
			}
		}
	}

	@Override
	public Blog getBlogById(Long id) {
		return BlogDao.findById(id);
	}

	@Override
	public List<Blog> getAllBlogs() {
		return BlogDao.findAll();
	}

}
