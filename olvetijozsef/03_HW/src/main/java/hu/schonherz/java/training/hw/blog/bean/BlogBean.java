package hu.schonherz.java.training.hw.blog.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Bean class for blogs.
 * 
 * @author Ölveti József
 * 
 */
public class BlogBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<Blog> blogs;

	public BlogBean() {
		super();
	}

	public List<Blog> getBlogs() {
		return blogs;
	}

	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}

}
