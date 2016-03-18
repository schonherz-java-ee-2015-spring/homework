package hu.schonherz.java.training.hw3.beans;

import java.io.Serializable;
import java.util.List;

/**
 * An Object to store data about blogs.
 * This object contains the id, name and the content of each blog.
 * */
public class BlogBean implements Serializable{

	private static final long serialVersionUID = 1L;

	public BlogBean() {
		super();
	}

	List<String> blogNames;
	List<String> blogContents;
	List<Integer> ids;

	/**
	 * @return the blogNames
	 */
	public List<String> getBlogNames() {
		return blogNames;
	}
	/**
	 * @param blogNames the blogNames to set
	 */
	public void setBlogNames(List<String> blogNames) {
		this.blogNames = blogNames;
	}
	/**
	 * @return the blogContents
	 */
	public List<String> getBlogContents() {
		return blogContents;
	}
	/**
	 * @param blogContents the blogContents to set
	 */
	public void setBlogContents(List<String> blogContents) {
		this.blogContents = blogContents;
	}
	/**
	 * @return the ids
	 */
	public List<Integer> getIds() {
		return ids;
	}
	/**
	 * @param ids the ids to set
	 */
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	} 
}
