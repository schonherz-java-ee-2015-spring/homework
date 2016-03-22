package hu.schonherz.homework3.blog;

import java.io.Serializable;

/**
 * @author Atka
 *
 */
public class Blog implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String text;

	public Blog() {
		super();
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
}
