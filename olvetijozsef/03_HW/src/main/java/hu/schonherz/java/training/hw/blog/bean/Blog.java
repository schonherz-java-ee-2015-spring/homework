package hu.schonherz.java.training.hw.blog.bean;

/**
 * Implments the blogs.
 * 
 * @author Ölveti József
 *
 */
public class Blog {
	private int id;
	private String title;
	private String content;
	private String date;

	public Blog(int id, String title, String content, String date) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.date = date;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", content=" + content + ", date=" + date + "]";
	}

}
