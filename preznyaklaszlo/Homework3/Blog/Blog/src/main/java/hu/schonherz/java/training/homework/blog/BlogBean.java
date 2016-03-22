package hu.schonherz.java.training.homework.blog;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlogBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2649125284237349585L;

	public BlogBean() {
		super();
	}

	List<String> titles = new ArrayList<String>();
	List<String> writings = new ArrayList<String>();
	List<Integer> ids = new ArrayList<Integer>();

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}

	public List<String> getWritings() {
		return writings;
	}

	public void setWritings(List<String> writings) {
		this.writings = writings;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

}
