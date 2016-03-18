package hu.schonhertz.training.blog.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import hu.schonhertz.training.blog.Blog;

/**
 * Stores the blogs.
 * 
 * @author Mark Bohan
 *
 */
public class BlogsBean implements Serializable {
	private static final long serialVersionUID = -4056843986599380729L;

	private List<Blog> blogs;
	
	private int lastID;
	
	/**
	 * 
	 */
	public BlogsBean() {
		this.blogs = new ArrayList<Blog>();
		lastID = 0;
	}

	
	/**
	 * For having unique id for each blog.
	 * @return an id,no blog should have yet.
	 */
	public int requestID(){
		return lastID++;
	}

	/**
	 * Finding blogs by id.
	 * @param id the id of blog, we are looking for.
	 * @return the Blog object, we are looking for.
	 */
	public Blog findBlog(final int id){
		return blogs.stream().filter(p -> p.getId() == id).findFirst().get();
	}

	
	/**
	 * @return the list of all blogs.
	 */
	public List<Blog> getBlogs() {
		return blogs;
	}


	/**
	 * @param blogs the list of all blogs.
	 */
	public void setBlogs(List<Blog> blogs) {
		this.blogs = blogs;
	}
}
