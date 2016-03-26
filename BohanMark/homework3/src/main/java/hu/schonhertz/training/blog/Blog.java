package hu.schonhertz.training.blog;

/**
 * Contains the information of a blog entry.
 * 
 * @author Mark Bohan
 *
 */
public class Blog {
	private Integer id;
	private String name;
	private String text;

	
	
	/**
	 * @param id the id of the blog. Must be unique.
	 * @param name the name of the blog.
	 * @param text the content of the blog.
	 */
	public Blog(Integer id, String name, String text) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
	}

	/**
	 * @return the id of the blog.
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the name of the blog.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name of the blog.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the text of the blog.
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text of the blog.
	 */
	public void setText(String text) {
		this.text = text;
	}

}
