package hu.schonherz.homework.blogApplication;

import java.io.Serializable;
import java.util.List;

public class BlogBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Blog> blogs;

	public BlogBeans() {
		super();
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}
