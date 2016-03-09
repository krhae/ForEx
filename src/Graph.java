import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	private Map<String, Vertex> vertices;
	
	public Graph() {
		this.vertices = new HashMap<String ,Vertex>();
	}
	
	public void addVertex(String key, Vertex newVertex) {
		vertices.put(key, newVertex);
	}
	
	public Vertex[] getVertices() {
		return this.vertices.values().toArray(new Vertex[0]);
	}
	
	public Vertex getVertex(String key) {
		return vertices.get(key);
	}
	
}
