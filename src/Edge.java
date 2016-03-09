
public class Edge {
	private double weight;
	private Vertex start;
	private Vertex end;

	public Edge(Vertex v1, Vertex v2, double weight) {
		this.weight = weight;
		this.start = v1;
		v1.addEdge(this);
		this.end = v2;
		v2.addEdge(this);
	}
	
	public double getWeight() {
		return this.weight;
	}
	
	public String toString() {
		return this.start.getName() + " " + this.end.getName() + " " + this.getWeight() + "\n";
	}
	
}
