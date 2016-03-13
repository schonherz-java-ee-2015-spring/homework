package hu.schonherz.homework.comparator.comment;

import java.util.Comparator;

import hu.schonherz.homework.pojo.Comment;

/**
 * This class sorts in ascending order Comment objects by their contents
 * 
 * @author Iványi-Nagy Gábor
 */
public class CommentComparatorByContent implements Comparator<Comment> {

	@Override
	public int compare(Comment firstComment, Comment secondComment) {
		return firstComment.getContent().compareToIgnoreCase(secondComment.getContent());
	}

}
