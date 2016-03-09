import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private List<Edge> edges;
	
	public Vertex(String name) {
		this.name = name;
		this.edges = new ArrayList<Edge>();
	}
	
	public String getName() {
		return this.name;
	}
	
	// Add Edge
	public boolean addEdge(Edge newEdge) {
		return edges.add(newEdge);
	}
	
	public String toString() {
		String returnString = this.name + "\n";
		
		for ( Edge edge: edges ) {
			returnString += edge.toString();
		}
		
		return returnString + "\n";
	}
}
