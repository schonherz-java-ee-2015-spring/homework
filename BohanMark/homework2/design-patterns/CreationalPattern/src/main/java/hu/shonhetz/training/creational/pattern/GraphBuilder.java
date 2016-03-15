package hu.shonhetz.training.creational.pattern;

/**
 * 
 * 	TODO javadocs
 * 
 * @author s01y0m
 *
 * @param <K>
 * @param <V>
 */
public interface GraphBuilder<V> {
	/**
	 * 
	 * Adds node to graph
	 * @param k	is the key of the node
	 * @param v is the value of the node
	 * @return this
	 */
	public GraphBuilder<V> addNode(Integer k, V v);
	/**
	 * 
	 * Adds edge between two nodes.
	 * @param f	is one of the connected nodes
	 * @param s is the other of connected nodes
	 * @param l is the distance between two nodes
	 * @return this
	 */
	public GraphBuilder<V> addEdge(Integer f, Integer s, Integer l);
	/**
	 * 
	 * Finalize the graph.
	 * 
	 * @return the finished graph.
	 */
	public Graph<V> build(); 
}
