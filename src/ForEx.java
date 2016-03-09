
public class ForEx {

	private static String[] tempForExData = {
	     "EUR GBP 0.7737",
	     "GBP EUR 1.2920",
	     "EUR USD 1.0978",
	     "USD EUR 0.9107",
	     "GBP USD 1.4186",
	     "USD GBP 0.7047",
	     "USD CHF 0.9972",
	     "CHF USD 1.0023",
	     "USD JPY 112.51",
	     "JPY USD 0.0088",
	     "EUR CHF 1.0953",
	     "CHF EUR 0.9127",
	     "EUR JPY 123.56",
	     "JPY EUR 0.0080",
	     "GBP JPY 159.64",
	     "JPY GBP 0.0062"
	};
	private static String[] vertexNames = {
		"USD",
		"EUR",
		"GBP",
		"CHF",
		"JPY"
	};
	
	public static void main( String[] args ) {
		
		Graph graph = new Graph();
		
		/* POPULATE GRAPH */
		
		// Populate vertices
		for (String name : vertexNames) {
			graph.addVertex(name, new Vertex(name));
		}
		
		// Add all edges
		for (String exchangeRate: tempForExData ) {
			// Parse the string 
			String[] split = exchangeRate.split("\\s+");
			Vertex v1 = graph.getVertex(split[0]);
			Vertex v2 = graph.getVertex(split[1]);
			double weight = Double.parseDouble(split[2]);
			
			// Add the edge
			Edge newEdge = new Edge(v1, v2, weight);
		}
		
		// Print out the Graph Vertices and their Edges
		for ( Object vertex : graph.getVertices()) {
			System.out.println(vertex);
		}
	}

}
