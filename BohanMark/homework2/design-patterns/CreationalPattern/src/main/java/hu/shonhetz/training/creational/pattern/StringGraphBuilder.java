/**
 * 
 */
package hu.shonhetz.training.creational.pattern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Use to create Graph<String>.
 * 
 * @see Graph
 * 
 * @author Mark Bohan
 *
 */
public class StringGraphBuilder implements GraphBuilder<String> {

	private Map<Integer, String> nodes;
	private List<Edge> edges;

	@SuppressWarnings("javadoc")
	public StringGraphBuilder() {
		super();
		this.nodes = new HashMap<Integer, String>();
		this.edges = new ArrayList<Edge>();
	}

	
	public GraphBuilder<String> addNode(Integer k, String v) {
		nodes.put(k, v);
		return this;
	}

	public GraphBuilder<String> addEdge(Integer f, Integer s, Integer l) {
		edges.add(new Edge(f, s, l));
		return this;
	}
	
	public Graph<String> build() {
		return new Graph<String>(nodes, edges);
	}

	

}
