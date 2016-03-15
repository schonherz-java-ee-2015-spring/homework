
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import hu.shonhetz.training.creational.pattern.Graph;
import hu.shonhetz.training.creational.pattern.StringGraphBuilder;

@SuppressWarnings("javadoc")
public class StringGraphBuilderTest {

	private StringGraphBuilder stringGraphBuilder;

	@Before
	public void setUp() throws Exception {
		stringGraphBuilder = new StringGraphBuilder();
	}

	@Test
	public void testDijkstra() {
		for (Integer i = 0; i < 3; ++i) {
			stringGraphBuilder.addNode(i, i.toString());
		}

		Graph<String> testableGraph = stringGraphBuilder.addEdge(0, 1, 1).addEdge(1, 2, 1).addEdge(0, 2, 3).build();
		List<Integer> path = testableGraph.dijkstra(0, 2);

		assertEquals(path.size(), 3);

		Integer expected[] = { 0, 1, 2 };
		for (int i = 0; i < 3; ++i){
			System.err.println(i+": " +path.get(i)+" "+expected[i]);
		}

		for (int i = 0; i < 3; ++i)
			assertEquals(path.get(i), expected[i]);
	}
}
