package hu.schonherz.homework.headswitcher.blog.beans;

public class BlogPostBean {
	private static int idc;
	private int id;
	private String title;
	private String Content; 
	public int getId() {
		return id;
	}
	
	
	public BlogPostBean() {
		super();
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public BlogPostBean(String title, String content) {
		super();
		this.id = idc;		
		idc++;
		this.title = title;
		Content = content;
	}
	
	
}
