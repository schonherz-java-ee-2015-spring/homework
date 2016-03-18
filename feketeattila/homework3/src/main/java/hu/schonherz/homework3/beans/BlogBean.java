package hu.schonherz.homework3.beans;

import java.io.Serializable;
import java.util.List;

import hu.schonherz.homework3.blog.Blog;

/**
 * @author Atka
 *
 * The bean to store our blogposts
 */
public class BlogBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Blog> blogs;

	public BlogBean() {
		super();
	}

	/**
	 * @return The list of blogs
	 */
	public List<Blog> getBlogs() {
		return blogs;
	}

	/**
	 * @param blogs
	 *            The list of blogs we want to set
	 */
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
}
