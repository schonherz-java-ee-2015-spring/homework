/**
 * 
 */
package hu.shonhetz.training.creational.pattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * Graph class for calculating Dijkstra.
 * 
 * @param <V>
 *            is the value type of each node
 * @see GraphBuilder
 * @see StringGraphBuilder
 *
 * @author Mark Bohan
 *
 */

public class Graph<V> {

	private Map<Integer, V> nodes;
	private List<Edge> edges;

	/**
	 * @param nodes
	 *            is the map of nodes for the graph
	 * @param edges
	 *            is a list, contains edges of graph
	 */
	public Graph(Map<Integer, V> nodes, List<Edge> edges) {
		super();
		this.nodes = nodes;
		this.edges = edges;
	}

	/**
	 * Asks for the value of a node.
	 * 
	 * @param id
	 *            is the id of the node
	 * @return value
	 */
	public V getValueOfNode(Integer id) {
		return nodes.get(id);
	}

	/**
	 * <p>
	 * calculates the shortest path
	 * <p>
	 * used resource: {@link http://cs.fit.edu/~ryan/java/programs/graph/Dijkstra-java.html}
	 * 
	 * @param from
	 *            is the path starting point
	 * @param to
	 *            is the path ending point
	 * @return the list of Integer object of the shortest path
	 * 
	 * @author Mark Bohan
	 * 
	 */
	public List<Integer> dijkstra(Integer from, Integer to) {
		if (!nodes.containsKey(from) || !nodes.containsKey(to) || to >= nodes.size() || to >= nodes.size())
			return null;
		final List<Integer> dist = new ArrayList<Integer>();
		final Integer[] pred = new Integer[nodes.size()];
		final boolean[] visited = new boolean[nodes.size()];

		for (int i = 0; i < nodes.size(); i++) {
			dist.add(Integer.MAX_VALUE);
		}
		
		dist.set(to, 0);

		for (int i = 0; i < dist.size(); i++) {
			final Integer next = minVertex(dist, visited);
			visited[next] = true;

			List<Edge> neighbors = findEdges(next);
			for (Edge edge : neighbors) {
				Integer d = dist.get(next) + edge.getLength();
				if (dist.get(edge.getSecond()) > d) {
					dist.set(edge.getSecond(), d);
					pred[edge.getSecond()] = next;
				}
			}

		}

		List<Integer> path = new ArrayList<Integer>();
		int x = from;
		while (x != to) {
			path.add(0, x);
			x = pred[x];
		}
		path.add(0, to);
		Collections.reverse(path);
		return path;
	}

	private List<Edge> findEdges(Integer next) {
		List<Edge> ret = new ArrayList<Edge>();

		for (Edge edge : edges) {
			if (edge.getFirst() == next)
				ret.add(edge);
			if (edge.getSecond() == next)
				ret.add(new Edge(next, edge.getFirst(), edge.getLength()));
		}

		return ret;
	}

	private Integer minVertex(List<Integer> dist, boolean[] visited) {
		int x = Integer.MAX_VALUE;
		int y = -1;
		for (int i = 0; i < dist.size(); i++) {
			if (!visited[i] && dist.get(i) < x) {
				y = i;
				x = dist.get(i);
			}
		}
		return y;
	}

}
