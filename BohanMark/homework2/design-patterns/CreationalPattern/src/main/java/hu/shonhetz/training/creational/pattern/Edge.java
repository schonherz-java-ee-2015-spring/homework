package hu.shonhetz.training.creational.pattern;



/**
 * 
 * Storing the edge of 2 nodes in a graph
 * @see Graph
 * @param <Integer> Type of the id of a node
 * 
 * @author Mark Bohan
 */
@SuppressWarnings("javadoc")
public class Edge {
	private Integer first;
	private Integer second;
	private Integer length;
	public Edge(Integer first, Integer second, Integer length) {
		super();
		this.first = first;
		this.second = second;
		this.length = length;
	}
	public Edge(Integer first, Integer second) {
		super();
		this.first = first;
		this.second = second;
		this.length = 1;
	}
	public Integer getFirst() {
		return first;
	}
	public void setFirst(Integer first) {
		this.first = first;
	}
	public Integer getSecond() {
		return second;
	}
	public void setSecond(Integer second) {
		this.second = second;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
}
