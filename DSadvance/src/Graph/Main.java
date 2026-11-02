package Graph;

import java.util.LinkedList;
import java.util.List;

public class Main {
public static void main(String[] args) {
	Graph g = new Graph(6,6);
	Graph g2 = new Graph(5);
	
	g.addEdge(0, 1);
	g.addEdge(0, 2);
	g.addEdge(1, 2);
	g.addEdge(2, 0);
	g.addEdge(2, 3);
	g.addEdge(1, 4);
	g.addEdge(4, 5);
	//g.displayMatrix();
	//g2.addEdgeList(0, 1);
	g2.addEdgeList(0, 2);
	g2.addEdgeList(1, 0);
	g2.addEdgeList(2, 1);
	//g2.addEdgeList(1, 4);
	g2.addEdgeList(0, 3);
	//g2.addEdgeList(3, 3);
	g2.addEdgeList(3, 4);
	//g2.addEdgeList(4, 2);
	//g2.addEdgeList(4, 5);
	//g2.addEdgeList(3, 5);
	//g2.addEdgeList(5, 6);
	//g2.addEdgeList(4, 6);
	//g2.displayList();
	//System.out.println();
	//g2.transpose();
	//g2.printTranspose();
	//System.out.println();
	//System.out.print("BFS of graph from 0 : ");
	//g2.BFSGraph(0);
	//System.out.print("\nBFS if node is disconnected from 0 : ");
	//g2.BFSDisconnected();
    //System.out.println();
    //System.out.println(g2.checkNodeLevel(4));
    //System.out.println(g2.canVisitAllNode(0));
    //g2.DFSsearch(0);
    //System.out.println();
    //g2.DFSdisConnectedSearch(0);
    //System.out.println();
    //g2.transitiveClosure();
    //System.out.println("Length of tc :"+g2.tc.length);
    
    //List<List<Integer>> l =g2.kosaraju();
    //List<List<Integer>> sccs = g2.tarjan(); 
        //System.out.println(g2.countIslands(M));
    //for (List<Integer> scc : sccs) {
    	// System.out.println(scc);
    //}
    //System.out.println(g2.isCyclicDirected());
    //System.out.println(g2.isCyclicUndirected());
    
 }
}
