package hu.schonherz.training.beans;

import java.io.Serializable;
import java.util.List;

public class BlogBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static List<Blogs> blogs;

	public BlogBeans() {
		super();
	}

	public static List<Blogs> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blogs> blogs) {
		BlogBeans.blogs = blogs;
	}

}
