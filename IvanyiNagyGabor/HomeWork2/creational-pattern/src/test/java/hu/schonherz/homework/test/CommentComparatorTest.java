package hu.schonherz.homework.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import hu.schonherz.homework.comparator.CommentComparatorFactory;
import hu.schonherz.homework.comparator.CommentComparatorType;
import hu.schonherz.homework.pojo.Comment;

/**
 * Test class for CommentComparators
 * 
 * @author Iványi-Nagy Gábor
 */
public class CommentComparatorTest {

	/**
	 * comments will contain the three Comment objects for the test cases
	 */
	private List<Comment> comments;

	/**
	 * Prepare the comments for all @Test methods
	 */
	@Before
	public void initCommentList() {
		comments = new ArrayList<Comment>();
		comments.add(new Comment("ABC", 10));
		comments.add(new Comment("PQRST", 100));
		comments.add(new Comment("Efgh", 1));
	}

	/**
	 * Empty the comments list
	 */
	@After
	public void setUpNullTheCommentList() {
		comments = null;
	}

	/**
	 * If the expected list and the result list are equals the test is
	 * succesful. The result list uses the CommentComparatorByNumberOfLikes
	 * class that it gets back from the CommentComparatorFactory.
	 */
	@Test
	public void sortedCommentListByNumberOfLikesASCTest() {
		List<Comment> expected = new ArrayList<Comment>();
		expected.add(new Comment("Efgh", 1));
		expected.add(new Comment("ABC", 10));
		expected.add(new Comment("PQRST", 100));

		List<Comment> result = comments.stream()
				.sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_NUMBER_OF_LIKES_ASC))
				.collect(Collectors.toList());

		assertTrue(expected.equals(result));
	}

	/**
	 * If the expected list and the result list are equals the test is
	 * succesful. The result list uses the CommentComparatorByNumberOfLikes
	 * class reverse that it gets back from the CommentComparatorFactory.
	 */
	@Test
	public void sortedCommentListByNumberOfLikesDESCTest() {
		List<Comment> expected = new ArrayList<Comment>();
		expected.add(new Comment("PQRST", 100));
		expected.add(new Comment("ABC", 10));
		expected.add(new Comment("Efgh", 1));

		List<Comment> result = comments.stream()
				.sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_NUMBER_OF_LIKES_DESC))
				.collect(Collectors.toList());

		assertTrue(expected.equals(result));
	}

	/**
	 * If the expected list and the result list are equals the test is
	 * succesful. The result list uses the CommentComparatorByContent class that
	 * it gets back from the CommentComparatorFactory.
	 */
	@Test
	public void sortedCommentListByContentASCTest() {
		List<Comment> expected = new ArrayList<Comment>();
		expected.add(new Comment("ABC", 10));
		expected.add(new Comment("Efgh", 1));
		expected.add(new Comment("PQRST", 100));

		List<Comment> result = comments.stream()
				.sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_CONTENT_ASC))
				.collect(Collectors.toList());

		assertTrue(expected.equals(result));
	}

	/**
	 * If the expected list and the result list are equals the test is
	 * succesful. The result list uses the CommentComparatorByContent class
	 * reverse that it gets back from the CommentComparatorFactory.
	 */
	@Test
	public void sortedCommentListByContentDESCTest() {
		List<Comment> expected = new ArrayList<Comment>();
		expected.add(new Comment("PQRST", 100));
		expected.add(new Comment("Efgh", 1));
		expected.add(new Comment("ABC", 10));

		List<Comment> result = comments.stream()
				.sorted(CommentComparatorFactory.getCommentComparator(CommentComparatorType.BY_CONTENT_DESC))
				.collect(Collectors.toList());

		assertTrue(expected.equals(result));
	}

}
