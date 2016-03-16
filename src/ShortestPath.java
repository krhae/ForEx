import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShortestPath {
	
	public final static double INFINITY = 10000.0000;
	public final static double ZERO = 0.0000;

	// PRE: Weighted graph, directional, non-negative weights
	// POST: Non-zero,
	public static void dijkstra(Graph graph, Vertex source, Vertex destination) {
		
		Map<String, Double> distances = new HashMap<String, Double>();
		List<Vertex> visited = new ArrayList<Vertex>();
		Vertex[] vertices = graph.getVertices();
		Vertex currentNode = source;
		Vertex previousNode = null;
		Vertex[] path = {};
		
		distances.put( source.getName(), ZERO );
		source.toggleVisited();
		visited.add(source);
		
		for ( Vertex node : vertices ) {
			String nodeName = node.getName();
			
			if(!distances.containsKey(nodeName))
				distances.put( nodeName, INFINITY );
		}
		
		
		while ( currentNode != destination) {
			
			List<Edge> currentNodeEdges = currentNode.getEdges();
			Vertex currentMin = null;
			
			for ( Edge edge : currentNodeEdges ) {
				
				String edgeId = edge.getEndNode().getName();
				double currentDistance = distances.get(edgeId);
				
				if ( currentDistance == INFINITY ) {
					currentDistance = ZERO;
				}
				
				currentDistance += edge.getWeight();
				
				if ( currentDistance < distances.get(edgeId) ) {
					distances.put( edgeId, currentDistance);	
				}
				
				if ( currentMin == null || distances.get(edgeId) < distances.get(currentMin.getName())) {
					currentMin = edge.getEndNode();
				}
			}
			
			
			System.out.println(currentMin.getName() + "\n");
			
			currentNode.toggleVisited();
			visited.add(currentNode);
			
			previousNode = currentNode;
			
			// Let the next node be the one with the min distance
			currentNode = currentMin;
				
		}
		
	}
	
	
}
