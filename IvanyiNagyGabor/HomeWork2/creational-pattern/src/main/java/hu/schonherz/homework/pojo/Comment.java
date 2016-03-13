package hu.schonherz.homework.pojo;

/**
 * This class contains the content of a comment and the number of likes
 * 
 * @author Iványi-Nagy Gábor
 */
public class Comment {

	private String content;
	private Integer numberOfLikes;

	/**
	 * 
	 * @param content is the content of Comment
	 * @param numberOfLikes is the number of likes of the Comment
	 */
	public Comment(String content, Integer numberOfLikes) {
		super();
		this.content = content;
		this.numberOfLikes = numberOfLikes;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the numberOfLikes
	 */
	public Integer getNumberOfLikes() {
		return numberOfLikes;
	}

	/**
	 * @param numberOfLikes
	 *            the numberOfLikes to set
	 */
	public void setNumberOfLikes(Integer numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

	/**
	 * Override hashCode() method
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((numberOfLikes == null) ? 0 : numberOfLikes.hashCode());
		return result;
	}

	/**
	 * Override equals(Object obj) method
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (numberOfLikes == null) {
			if (other.numberOfLikes != null)
				return false;
		} else if (!numberOfLikes.equals(other.numberOfLikes))
			return false;
		return true;
	}

	/**
	 * Override toString() method
	 */
	@Override
	public String toString() {
		return "Comment [content=" + content + ", numberOfLikes=" + numberOfLikes + "]";
	}

}
