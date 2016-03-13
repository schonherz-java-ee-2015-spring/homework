package hu.schonherz.homework.comparator.comment;

import java.util.Comparator;

import hu.schonherz.homework.pojo.Comment;

/**
 * This class sorts in ascending order Comment objects by their number of likes
 * 
 * @author Iványi-Nagy Gábor
 */
public class CommentComparatorByNumberOfLikes implements Comparator<Comment> {

	@Override
	public int compare(Comment firstComment, Comment secondComment) {
		return firstComment.getNumberOfLikes().compareTo(secondComment.getNumberOfLikes());
	}

}
