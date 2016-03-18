package hu.schonherz.training.beans;

import java.io.Serializable;
import java.util.List;

public class BlogBeans implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private static List<Blogs> blogs;
	private static Blogs blogTest = new Blogs("1", "Katsa", "Teszt szöveg ehhez a retkes bloghoz!");
	
	public static void main(String[] args) {
		blogs.add(blogTest);
	}
	
	public BlogBeans() {
		super();
	}

	public static List<Blogs> getBlogs() {
		return blogs;
	}

	public static void setBlogs(List<Blogs> blogs) {
		BlogBeans.blogs = blogs;
	}

}
