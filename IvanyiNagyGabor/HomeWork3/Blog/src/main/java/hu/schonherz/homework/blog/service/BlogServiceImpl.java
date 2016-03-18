package hu.schonherz.homework.blog.service;

import java.util.List;

import hu.schonherz.homework.blog.dao.BlogDao;
import hu.schonherz.homework.blog.model.Blog;

/**
 * @author Iványi-Nagy Gábor
 *
 */
public class BlogServiceImpl implements BlogService {

	// Create blog if the title is not null and the content is not null and not exist this title
	@Override
	public boolean createBlog(Blog blog) {
		if (blog.getTitle() != null && blog.getContent() != null) {
			if (BlogDao.findAll().stream()
					.anyMatch(currentBlog -> currentBlog.getTitle().equalsIgnoreCase(blog.getTitle())) == false) {
				BlogDao.addBlog(blog);
				return true;
			}
		}
		return false;
	}

	
	// get Blog by id
	@Override
	public Blog getBlogById(Long id) {
		return BlogDao.findById(id);
	}

	
	// get all Blogs
	@Override
	public List<Blog> getAllBlogs() {
		return BlogDao.findAll();
	}

}
