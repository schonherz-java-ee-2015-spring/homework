package hu.schonherz.homework.demo;

import java.util.ArrayList;
import java.util.List;

import hu.schonherz.homework.comparator.CommentComparatorFactory;
import hu.schonherz.homework.comparator.CommentComparatorType;
import hu.schonherz.homework.pojo.Comment;

/**
 * FactoryPatternDemo class
 * 
 * @author Iványi-Nagy Gábor
 */
public class FactoryPatternDemo {

	public static void main(String[] args) {

		/**
		 * Create three Comment objects and put into the list
		 */
		List<Comment> comments = new ArrayList<Comment>();
		comments.add(new Comment("Fifty", 50));
		comments.add(new Comment("THOUSAND", 1000));
		comments.add(new Comment("one", 1));

		/**
		 * Sort and print the list by number of likes ASC
		 */
		System.out.println("Sort by number of likes ASC:");
		comments.stream()
				.sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_NUMBER_OF_LIKES_ASC))
				.forEach(System.out::println);

		/**
		 * Sort and print list by number of likes DESC
		 */
		System.out.println("\nSort by number of likes DESC:");
		comments.stream()
				.sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_NUMBER_OF_LIKES_DESC))
				.forEach(System.out::println);

		/**
		 * Sort and print list by content ASC
		 */
		System.out.println("\nSort by content ASC:");
		comments.stream().sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_CONTENT_ASC))
				.forEach(System.out::println);

		/**
		 * Sort and print list by content DESC
		 */
		System.out.println("\nSort by content DESC:");
		comments.stream().sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_CONTENT_DESC))
				.forEach(System.out::println);

	}
}
