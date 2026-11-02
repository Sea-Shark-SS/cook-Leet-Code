package GraphAlgorithm;

import java.util.Arrays;

public class Shortestpath {

	// Dijkstra’s Algorithm geeks for geeks
	void dijkstrageeks(int[][] adj,int src) {
		int V=adj.length;
		int[] dst = new int[adj.length];//output array
	//dst[i] will hold the shortest distance from source to i
	//sptset[i] will true if vertex i is included in
	//shortest path tree or shortest distance from source 
		// to i is finalized
		boolean[] sptset =new boolean[V];
	//initialize all distances as infinite and sptset as false
		for(int i=0 ; i<V;i++) {
			dst[i]=Integer.MAX_VALUE;
			sptset[i]=false;
		}
	//distance of src vertex from itself is 0
		dst[src]=0;
	//Find shortest path for all vertices
	for(int c =0;c<V-1;c++) {
		//pick the minimum distance vertex from the set
		//of vertices not yet processed ,u is always equal to src
		// in first iteration
		int u=minDistance(dst,sptset);
		//marked the picked vertex as processed
		sptset[u]=true;
		//update distance value of the adjacent vertices
		//of the picked array
		for(int v =0 ; v<V;v++) {
			//first update the dst[v] only if is not in sptset
			//there is an edge from u to v ,and total 
			//weight of path from src to v through u is 
			//smaller than current value of dst[v]
			if(!sptset[v] && adj[u][v]!=0 && dst[u]!=Integer.MAX_VALUE && dst[u]+adj[u][v]<dst[v] )
				dst[v]=dst[u]+adj[u][v];
		}
		
	}
		printSolution(dst);		
	}
	private int minDistance(int[] dst,boolean[] sptset) {
		int V=dst.length;
		int min = Integer.MAX_VALUE;//initialize the min value
		int minIndex=-1;
		for(int v=0 ; v<V;v++)
			if(sptset[v]==false && dst[v]<=min) {
				min=dst[v];
				minIndex=v;
			}
		return minIndex;
	}
	private void printSolution(int[] dst) {
		System.out.println("Vertex \t\t distance from source ");
		
		int i=0;
		for(int x : dst)
			System.out.println((i++)+"\t\t "+x+" ");
	
		System.out.println();
	}
	//<------End of DA geeks fpr geeks
	//----------------->Dijkstra main
	private final int inf =  Integer.MAX_VALUE;
	public void Dijkstra(int[][] graph,int src) {
		int n = graph.length;
		int[] dist= new int[n];
		Arrays.fill(dist, inf);
		dist[src]=0;
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		for(int i=0 ; i<n ; i++) {
	    //Dijkstra begins
			int u=-1 ;//default 
			int min = inf;
			//unvisited and valid node selection with not infinite distance
			for(int j=0 ; j<n ; j++)
			if(!visited[j] && dist[j]<min) {
				min=dist[j];
				u=j;
			}
			 if (u == -1) break; // no more reachable nodes
			 visited[u] = true;
			for (int k=0 ; k<n ; k++)
				if(!visited[k] && graph[u][k]!=0 && dist[u]!=inf &&
						dist[u]+graph[u][k]<=dist[k]) {
				dist[k]=dist[u]+graph[u][k];
				
				}
			
		}
		
		// print the distance
		System.out.println("From source = "+src +" Distances are : ");
		for(int x : dist)
			System.out.print(x+" ");
		System.out.println();
	}
	
	//<-----------------End of Dijkstra
	//----------------> bellman ford algorithm
	public int[] bellmanford(int[][] adj,int src,int V) {
		
		// Initially distance from source to all other vertices 
        // is not known(Infinite).
		int[] dst = new int[V];
		Arrays.fill(dst, Integer.MAX_VALUE);
		dst[src]=0;
		 // Relaxation of all the edges V times, not (V - 1) as we  
        // need one additional relaxation to detect negative cycle
		for(int i=0 ; i<V;i++) {
			for(int[] j : adj) {
				int u=j[0];
				int v =j[1];
				int wt =j[2];
				if(dst[u]!=Integer.MAX_VALUE && dst[u]+wt<dst[v]) {
					// If this is the Vth relaxation, then there is
                    // a negative cycle
					if(i==V-1)
						return new int[] {-1};
					// Update shortest distance to node v
					dst[v]=dst[u]+wt;
				}
			}
		}
		
		return dst;
	}
	//<-------------end of bellman ford
	//----------------->Floyd warshell shortest path
	public void  floydShortestPath(int[][] adj) {
		int V=adj.length;
		// Add all vertices one by one to
        // the set of intermediate vertices.
		for(int k=0 ; k<V;k++)
			// Pick all vertices as source one by one
		for(int i = 0;i<V;i++)
			// Pick all vertices as destination
            // for the above picked source
		for(int j=0  ;j<V;j++)
                 // If vertex k is on the shortest path from
                // i to j, then update the value of graph[i][j]
			if((adj[i][j]==-1 || (adj[i][j]>adj[i][k]+adj[k][j]))
					&& (adj[k][j]!=-1 && adj[i][k]!=-1) )
			{
				adj[i][j]=adj[i][k]+adj[k][j];
			}
	}
	
	//<-----------------end of floyd warshell algorithm
	//johnson's algorithm for shortestpath
	private final int INF=Integer.MAX_VALUE;
	 // Bellman-Ford to compute potential h[]
    private  int[] bellmanFord(int[][] edges, int V) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, INF);
        dist[V] = 0; // new source

        // Build edge list including new vertex
        int[][] edgesWithExtra = Arrays.copyOf(edges, edges.length + V);
        for (int i = 0; i < V; i++) {
            edgesWithExtra[edges.length + i] = new int[]{V, i, 0};
        }

        // Relax edges V times
        for (int i = 0; i < V; i++) {
            for (int[] edge : edgesWithExtra) {
                int u = edge[0], v = edge[1], w = edge[2];
                if (dist[u] != INF && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return Arrays.copyOf(dist, V);
    }

    // Dijkstra using O(V^2) loop (no PQ, no minDistance, no sptSet)
    private int[] dijkstra(int[][] graph, int[][] alteredGraph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        Arrays.fill(dist, INF);
        boolean[] visited = new boolean[V];

        dist[src] = 0;

        for (int i = 0; i < V; i++) {
            // Find the unvisited vertex with the smallest distance
            int u = -1;
            int best = INF;
            for (int j = 0; j < V; j++) {
                if (!visited[j] && dist[j] < best) {
                    best = dist[j];
                    u = j;
                }
            }

            if (u == -1) break; // no reachable vertex
            visited[u] = true;

            // Relax neighbors
            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 && dist[u] != INF) {
                    int newDist = dist[u] + alteredGraph[u][v];
                    if (newDist < dist[v]) {
                        dist[v] = newDist;
                    }
                }
            }
        }

        return dist;
    }

    // Johnson’s Algorithm
    public void johnson(int[][] graph) {
        int V = graph.length;
        int[][] edges = new int[V * V][3];
        int index = 0;

        // Build edge list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    edges[index++] = new int[]{i, j, graph[i][j]};
                }
            }
        }
        edges = Arrays.copyOf(edges, index);

        // Get potentials with Bellman-Ford
        int[] h = bellmanFord(edges, V);

        // Reweight edges
        int[][] alteredGraph = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (graph[i][j] != 0) {
                    alteredGraph[i][j] = graph[i][j] + h[i] - h[j];
                }
            }
        }

        // Print altered graph
        System.out.println("Reweighted Graph:");
        for (int[] row : alteredGraph) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Run Dijkstra from each vertex
        for (int src = 0; src < V; src++) {
            int[] dist = dijkstra(graph, alteredGraph, src);
            System.out.println("\nShortest paths from vertex " + src + ":");
            for (int v = 0; v < V; v++) {
                if (dist[v] == INF) System.out.println("To " + v + " = INF");
                else {
                    // Convert back to original distance
                    int originalDist = dist[v] + h[v] - h[src];
                    System.out.println("To " + v + " = " + originalDist);
                }
            }
        }
    }
	
	
}
