package hu.schonherz.homework.comparator;

import java.util.Comparator;

import hu.schonherz.homework.comparator.comment.CommentComparatorByContent;
import hu.schonherz.homework.comparator.comment.CommentComparatorByNumberOfLikes;
import hu.schonherz.homework.pojo.Comment;

/**
 * Create a CommentComparatorFactory to generate CommentComparator objects
 * 
 * @author Iványi-Nagy Gábor
 */
public class CommentComparatorFactory {

	/**
	 * Private constructor, use the static getCommentComparator method if you
	 * want to create an instance
	 */
	private CommentComparatorFactory() {

	}

	/**
	 * Creates and gives back an instance that implements the Comparator interface
	 * 
	 * @param type
	 *            BY_CONTENT_ASC, BY_CONTENT_DESC, BY_NUMBER_OF_LIKES_ASC,
	 *            BY_NUMBER_OF_LIKES_DESC
	 * @return the actual Comparator
	 */
	public static Comparator<Comment> getCommentComparator(CommentComparatorType type) {
		if (type == null) {
			return null;
		}

		if (type.equals(CommentComparatorType.BY_CONTENT_ASC)) {
			return new CommentComparatorByContent();
		} else if (type.equals(CommentComparatorType.BY_CONTENT_DESC)) {
			return new CommentComparatorByContent().reversed();
		} else if (type.equals(CommentComparatorType.BY_NUMBER_OF_LIKES_ASC)) {
			return new CommentComparatorByNumberOfLikes();
		} else if (type.equals(CommentComparatorType.BY_NUMBER_OF_LIKES_DESC)) {
			return new CommentComparatorByNumberOfLikes().reversed();
		}

		return null;
	}
}
