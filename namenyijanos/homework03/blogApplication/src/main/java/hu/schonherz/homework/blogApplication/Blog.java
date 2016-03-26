package hu.schonherz.homework.blogApplication;

public class Blog {

	private int id;
	private String title;
	private String text;

	public Blog(int id, String title, String text) {
		super();
		this.id = id;
		this.title = title;
		this.text = text;
	}

	public Blog() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
