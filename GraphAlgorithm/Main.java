package GraphAlgorithm;

public class Main {

	public static void main(String[] args) {
    /*
	Graph g1 = new Graph(6);
	Graph g2 = new Graph(6,6);
	
	
	//g1.addEdgeList(0, 1);
	g1.addEdgeList(1, 2);
	g1.addEdgeList(2, 3);
	g1.addEdgeList(3, 4);
	g1.addEdgeList(5, 1);
	g1.addEdgeList(4, 3);
	g1.addEdgeList(4, 5);
	g1.addEdgeList(0, 2);
	g1.addEdgeList(1, 3);
	g1.addEdgeList(2, 4);
	g1.addEdgeList(3, 5);
	g1.addEdgeList(5, 2);
	g1.addEdgeList(4, 1);
	g1.addEdgeList(4, 2);
	g1.printlist();
	g2.addEdge(0, 1);
	g2.addEdge(0, 3);
	g2.addEdge(1, 3);
	g2.addEdge(1, 5);
	g2.addEdge(2, 1);
	g2.addEdge(2, 4);
	g2.addEdge(2, 5);
	g2.addEdge(3, 1);
	g2.addEdge(3, 4);
	g2.addEdge(4, 2);
	g2.addEdge(4, 5);
	g2.addEdge(5, 1);
	g2.addEdge(5, 3);
    */
	//g2.printMatrix();
	//g1.BreadthFirstSearch(0);
	//g1.BFSdisconnected();
	//g1.DepthFirstSearch(1);
	//g1.DFSdisconnected();
	/*
	Graph g3 = new Graph(3);
	g3.addEdgeListUndirected(0, 1);
	g3.addEdgeListUndirected(1,2);
	g3.addEdgeListUndirected(2, 0);
	*/
	//g3.printMatrix();
	//g3.floodFill(1, 1, 3);
	//g3.printMatrix();
	//g2.printMatrix();
	//g2.floodFill(0, 1, 6);
	//g2.printMatrix();
	//System.out.println(g1.isBipertite());
	//System.out.println(g1.isCyclic());
	//System.out.println(g1.detectcycle());
	//System.out.println(g3.isCyclicdirected());
	/* for negative cycle
	
	Graph g4 =new Graph(5);
	g4.addWeightedEdge(0, 1, -1);
	g4.addWeightedEdge(0, 2, 4);
	g4.addWeightedEdge(1, 2, 3);
	g4.addWeightedEdge(1, 3, 2);
	g4.addWeightedEdge(1, 4, 2);
	g4.addWeightedEdge(3, 1, 1);
	g4.addWeightedEdge(3, 2, 5);
	g4.addWeightedEdge(4, 3, -3);
	System.out.println(g4.containsNegativeCycle());
	System.out.println(g4.containsNegativeCycleFW());
	*/
	/*For count number of n cycle
	 Graph g5 = new Graph(5,5);
	 int n = 4;
     g5.addEdgeUndirected(0, 1);
     g5.addEdgeUndirected(0, 3);
     g5.addEdgeUndirected(1, 2);
     g5.addEdgeUndirected(1, 4);
     g5.addEdgeUndirected(2, 3);
     g5.addEdgeUndirected(4, 0);
     g5.addEdgeUndirected(3, 4);
     
	 g5.printMatrix();
     System.out.println(g5.countNumberOfCycle(n));
     */
	Graph g6  = new Graph(9,9);
	g6.addWeightedEdgeundirected(0, 1, 4);
	g6.addWeightedEdgeundirected(1, 2, 8);
	g6.addWeightedEdgeundirected(2, 3, 7);
	g6.addWeightedEdgeundirected(3, 4, 5);
	g6.addWeightedEdgeundirected(4, 5, 1);
	g6.addWeightedEdgeundirected(5, 2, 4);
	g6.addWeightedEdgeundirected(5, 3, 1);
	g6.addWeightedEdgeundirected(5, 6, 2);
	g6.addWeightedEdgeundirected(6, 8, 6);
	g6.addWeightedEdgeundirected(8, 2, 2);
	g6.addWeightedEdgeundirected(6, 7, 1);
	g6.addWeightedEdgeundirected(7, 8, 7);
	g6.addWeightedEdgeundirected(7, 1, 1);
	g6.addWeightedEdgeundirected(0, 7, 8);
	//g6.printMatrix();
	//g6.dijkstra(0);
	
	/*
	int[][] edges = new int[][] {
        {1, 3, 2},
        {4, 3, -1},
        {2, 4, 1},
        {1, 2, 1},
        {0, 1, 5}
    };
	g6.bellmanford(0,edges,5);
	*/
	Graph g7= new Graph(0);
	/*int[][] g701 = {
            {0, 4, -1, 5, -1},
            {-1, 0, 1, -1, 6},
            {2, -1, 0, 3, -1},
            {-1, -1, 1, 0, 2},
            {1, -1, -1, 4, 0}
        };
	g7.floydWarshell(g701);
	for(int i=0 ;i<5 ;i++) {
		for(int x : g701[i])
			System.out.print(x+" ");
	System.out.println();
	  } */
	int[][] graph702 = {
            {0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
	Shortestpath s = new Shortestpath();
	//s.Dijkstra(graph702, 0);
	//s.dijkstrageeks(graph702, 0);
	s.johnson(graph702);
	
	}
}
