import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private String name;
	private List<Edge> edges;
	private boolean isVisted;
	
	public Vertex(String name) {
		this.name = name;
		this.edges = new ArrayList<Edge>();
		this.isVisted = false;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void toggleVisited() {
		this.isVisted = true;
	}
	
	public boolean isVisited() {
		return this.isVisted;
	}
	
	// Add Edge
	public boolean addEdge(Edge newEdge) {
		return edges.add(newEdge);
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	
	public String toString() {
		String returnString = this.name + "\n";
		
		for ( Edge edge: edges ) {
			returnString += edge.toString();
		}
		
		return returnString + "\n";
	}
}
