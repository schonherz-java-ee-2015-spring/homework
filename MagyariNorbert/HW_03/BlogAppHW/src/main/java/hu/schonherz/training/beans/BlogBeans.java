package hu.schonherz.training.beans;

import java.io.Serializable;

public class BlogBeans implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String entry;
	private String title;
	private int id;

	public BlogBeans() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	
	

}
