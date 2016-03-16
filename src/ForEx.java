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
	
	private static String[] testData = {
			"A B 7",
			"B C 10",
			"C D 11",
			"D E 6",
			"F E 9",
			"A C 9",
			"A F 14",
			"C F 2",
			"B D 15"
	};
	
	private static String[] testVertices = {
		"A",
		"B",
		"C",
		"D",
		"E",
		"F"
	};
	private static String[] vertexNames = {
		"USD",
		"EUR",
		"GBP",
		"CHF",
		"JPY"
	};
	
	private final static boolean VERBOSE = true;
	
	public static void main( String[] args ) {
		
		Graph graph = new Graph();
		
		long initTime = System.currentTimeMillis();
		
		
		/* POPULATE GRAPH */
		// Populate vertices
		for (String name : /*vertexNames*/ testVertices ) {
			graph.addVertex(name, new Vertex(name));
		}
		
		// Add all edges
		for (String exchangeRate: /*tempForExData*/ testData ) {
			// Parse the string 
			String[] split = exchangeRate.split("\\s+");
			Vertex v1 = graph.getVertex(split[0]);
			Vertex v2 = graph.getVertex(split[1]);
			double weight = Double.parseDouble(split[2]);
			
			// Add the edge
			new Edge(v1, v2, weight);
		}
		
		
		ShortestPath.dijkstra(graph, graph.getVertex("A"), graph.getVertex("E"));
		
		if(VERBOSE) {
			// Print out the Graph Vertices and their Edges
			for ( Object vertex : graph.getVertices()) {
				System.out.println(vertex);
			}			

			/* TIMER INFO */
			long endTime = System.currentTimeMillis();
			long totalTime = endTime - initTime;
			
			System.out.println("Time: " + totalTime + "ms\n");			
		}

	}

}
