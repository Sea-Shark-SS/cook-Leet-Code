package GraphAlgorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CompetetiveProblem {
 
	//-------------->Counting Island Algorithm
	private    boolean isSafe(int[][] M, int r, int c, 
               boolean[][] visited) {
int ROW = M.length;
int COL = M[0].length;

// r is in range, c is in range, value is '1' and not 
// yet visited
return r >= 0 && r < ROW && c >= 0 && c < COL 
   && M[r][c] == 1 && !visited[r][c];
}

// A utility function to do DFS for a 2D matrix.
// It only considers the 8 neighbours as adjacent vertices
 void DFS(int[][] M, int r, int c,
                 boolean[][] visited) {
// These arrays are used to get r and c numbers of 8
// neighbours of a given cell
int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 };
int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };

// Mark this cell as visited
visited[r][c] = true;

// Recur for all connected neighbours
for (int k = 0; k < 8; ++k) {
int newR = r + rNbr[k];
int newC = c + cNbr[k];
if (isSafe(M, newR, newC, visited)) 
DFS(M, newR, newC, visited);

}
}

// function that returns count of islands in a given matrix
 int countIslands(int[][] M) {
int ROW = M.length;
int COL = M[0].length;

// Make a boolean array to mark visited cells.
// Initially all cells are unvisited
boolean[][] visited = new boolean[ROW][COL];

// Initialize count as 0 and traverse through all 
// cells of the given matrix
int count = 0;
for (int r = 0; r < ROW; ++r) 
for (int c = 0; c < COL; ++c)

// If a cell with value '1' is not visited yet, 
// then a new island is found
if (M[r][c] == 1 && !visited[r][c]) {

// Visit all cells in this island.
DFS(M, r, c, visited);

// increment the island count
++count;
}


return count;
}
 //<-----------------End of counting Island
 //---------------> counting island using BFS
 public int countIsland(int[][] m) {
	 int count=0;
	 int row=m.length;
	 int col=m[0].length;
for(int i=0;i<row;i++)
	for(int j=0;j<col;j++)
		if(m[i][j]==1) {
			BFS(m,i,j);
			count++;
		}
	 return count;
 }
   private void BFS(int[][] m,int r,int c) {
	
	   int[] rNbr = { -1, -1, -1, 0, 0, 1, 1, 1 }; // Row offsets for 8 directions
       int[] cNbr = { -1, 0, 1, -1, 1, -1, 0, 1 };
      Queue<int[]> q =new LinkedList<>();
      q.add(new int[] {r,c});
      m[r][c]=0;
      while(!q.isEmpty()) {
    	  int[] cell = q.poll();
    	  int i=cell[0];
    	  int j=cell[1];
    	  // Go through all 8 adjacent cells
    	  for(int k=0;k<8;k++) {
    		  int newR = i + rNbr[k]; // Calculate new row index
              int newC = j + cNbr[k];
              if(isSafe(m,newR,newC)) {
            	  m[newR][newC]=0;
            	  q.add(new int[] {newR,newC});
              }
    	  }
      }
      
   }
   
   private boolean isSafe(int[][] m,int r,int c) {
	   int row=m.length;
	   int col=m[0].length;
	   return (r >= 0) && (r < row) && (c >= 0) && 
               (c < col) && (m[r][c] == 1);
   }
   
 
 //<---------------end of Counting Island
 
 //---------------->Flood fill Algorithm
 public void floodFill(int[][] img, int x,int y,int newcl) {
	 Queue<int[]> q = new LinkedList<>();
		// Rows and columns of the display
		int row=img.length;
		int col =img[0].length;
		int prev= img[x][y];
		if(prev==newcl) return;
		// Append the position of the starting 
        // pixel of the component
		q.add(new int[]{x,y});
		img[x][y]=newcl;
		// While the queue is not empty, i.e., the 
        // whole component having prevClr color
        // is not colored with newClr color
		while(!q.isEmpty()) {
			// Dequeue the front node
			int[] pos=q.poll();
			x=pos[0];
			y=pos[1];
            // Check if the adjacent pixels are valid and enqueue
           if(x+1<row && img[x+1][y]==prev) {
        	   img[x+1][y]=newcl;
        	   q.add(new int[] {x+1,y});
           }
           if(y+1<col && img[x][y+1]==prev) {
        	   img[x][y+1]=newcl;
        	   q.add(new int[] {x,y+1});
           }
           if(x-1>=0 && img[x-1][y]==prev) {
        	   img[x-1][y]=newcl;
        	   q.add(new int[] {x-1,y});
           }
           if(y-1>=0 && img[x][y-1]==prev) {
        	   img[x][y-1]=newcl;
        	   q.add(new int[] {x,y-1});
           }
		}		
 }
  //<---------------end of flood fill algorithm
   //--------------->Chech Bipertite Algorithm
 //Using BFS
   boolean isBipertite(List<List<Integer>> adl,int v) {
	   int[] c = new int[v];
	   Arrays.fill(c,-1);
	   // Iterate through all vertices to handle
       // disconnected graphs
	   for(int i=0 ; i<v ;i++) 
           // If the vertex is uncolored, start BFS from it
		   if(c[i]==-1)
		   {   // Assign first color (0)
			   c[i]=0;
			   Queue<Integer> q = new LinkedList<>();
			   q.add(i);
			   while(!q.isEmpty()) {
				   int u= q.poll();
				   for(int x : adl.get(u)) {

                       // If the adjacent vertex is
                       // uncolored, assign alternate color
                       if(c[x]==-1) {
                    	   c[x]=1-c[u];
                    	   q.add(x);
                           // If the adjacent vertex has the
                           // same color, graph is not
                           // bipartite
                       }
                       else if(c[x]==c[u])
                    	   return false;
				   }
			   }
		   }
       // If no conflicts in coloring, graph is bipartite   
	   return true;   
   }
   ///using DFS Check Bipertite
   boolean iSbipertite(List<List<Integer>> adl,int v) {
       // Initialize all vertices as uncolored
      int[] c = new int[v];
      Arrays.fill(c,-1);
      // Check each component of the graph
       for(int i=0  ;i<v ; i++) 
    	   // If the vertex is uncolored
    	   if(c[i]==-1) 
               // If DFS fails, the graph is not bipartite
            if(!dfs(adl,c,i,0))
            	return false;
    	   
	   return true;
   }
   private boolean dfs(List<List<Integer>> adl,int[] c,int i,int color) {
	   // Assign color to the current u
	   c[i]=color;
	// Iterate through all adjacent vertices
	   for(int u : adl.get(i)) {
		   if(c[u]==-1)
               // Assign alternate color to the adjacent u
			   if(!dfs(adl,c,u,1-i))
				   return false;
			   else if(c[u]==color)
				   return false;
	   }
	 return true;  
   }
   //<---------------end of bipertite
   //-----------------> bellman ford algorithm 
   //to Detect negative cycle
   private boolean bellman(int[][] adj,int src,int[] dist) {
	   int V = adj.length;

       // Step 1: Initialize distances from src to all other vertices as INFINITE
       Arrays.fill(dist, Integer.MAX_VALUE);
       dist[src] = 0;

       // Step 2: Relax all edges |V| - 1 times.
       for (int i = 1; i <= V - 1; i++) {
           for (int u = 0; u < V; u++) {
               for (int v = 0; v < V; v++) {
                   if (adj[u][v] != 0 && adj[u][v] != Integer.MAX_VALUE) {
                       int weight = adj[u][v];
                       if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                           dist[v] = dist[u] + weight;
                       }
                   }
               }
           }
       }

       // Step 3: Check for negative-weight cycles.
       for (int u = 0; u < V; u++) {
           for (int v = 0; v < V; v++) {
               if (adj[u][v] != 0 && adj[u][v] != Integer.MAX_VALUE) {
                   int weight = adj[u][v];
                   if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                       return true; // Negative cycle found
                   }
               }
           }
       }

       return false; // No negative cycle found
   }
   boolean detectNegativeCycle(int[][] adj) {
	   int V = adj.length;
	   

       // To keep track of visited vertices to avoid recomputations.
       boolean visited[] = new boolean[V];
       Arrays.fill(visited, false);

       // This array is filled by Bellman-Ford
       int dist[] = new int[V];

       // Call Bellman-Ford for all those vertices that are not visited
       for (int i = 0; i < V; i++) {
           if (!visited[i]) {
               // If cycle found
               if (bellman(adj, i, dist)) {
                   return true;
               }

               // Mark all vertices that are visited in above call.
               for (int j = 0; j < V; j++) {
                   if (dist[j] != Integer.MAX_VALUE) {
                       visited[j] = true;
                   }
               }
           }
       }
       return false;
   }
   //<-------------end for bellman ford
   //--------------->Count cycle Algorithm 
   //helper DFS for count cycle
   private int count=0;
   private void dfsc(int[][] adj,boolean[] mark,int n,int vert,int start) {
    	// mark the vertex vert as visited
    	mark[vert]=true;
    	// if the path of length (n-1) is found
    	if(n==0) {
    		// mark vert as un-visited to 
            // make it usable again
    		mark[vert]=false;
    		// Check if vertex vert end 
            // with vertex start
    		if(adj[vert][start]==1) {
    			count++;
    			return;
    		}else
    			return;
    	}
    	// For searching every possible 
        // path of length (n-1)
    	for(int i=0; i<adj.length;i++)
    		if(!mark[i] && adj[vert][i]==1)
    			// DFS for searching path by
                // decreasing length by 1
    			dfsc(adj,mark,n-1,i,start);

        // marking vert as unvisited to make it
        // usable again
    	mark[vert]=false;
    	
   }
// Count cycles of length N in an 
   // undirected and connected graph.
   
   
   int countCycle(int[][] adj,int n) {
	// all vertex are marked un-visited
       // initially.
	   int v=adj.length;
	   
	   
	   boolean[] mark = new boolean[v];
	// Searching for cycle by using 
       // v-n+1 vertices
	   for(int i=0 ; i<v-(n-1);i++) {
		   dfsc(adj,mark,n-1,i,i);
		   // ith vertex is marked as visited
           // and will not be visited again
		   mark[i]=true;
	   }
	  return count/2;
   }
   
   //<-----------------------End of count cycles 
   //--> Detect negative Cycle using floyd warshell algorithm
   public boolean neagtiveCycleFloydWarshell(int[][] adj) {
	   int V=adj.length;
	   /* dist[][] will be the output matrix that will 
       finally have the shortest 
       distances between every pair of vertices */
	   int[][] dst = new int[V][V];
	   /* Initialize the solution matrix same as input
       graph matrix. Or we can say the initial values 
       of shortest distances are based on shortest 
       paths considering no intermediate vertex. */
	   for(int i=0;i<V;i++)
		   for(int j=0 ; j<V;j++)
			  if(i==j)
				  dst[i][j]=0;// Distance to self is zero
			  else if(adj[i][j] != 0)
				  dst[i][j]=adj[i][j];
			  else
				  dst[i][j]=Integer.MAX_VALUE;
	   /* Add all vertices one by one to the set of 
       intermediate vertices.
       ---> Before start of a iteration, we have shortest
           distances between all pairs of vertices such 
           that the shortest distances consider only the
           vertices in set {0, 1, 2, .. k-1} as intermediate 
           vertices.
       ----> After the end of a iteration, vertex no. k is 
           added to the set of intermediate vertices and 
           the set becomes {0, 1, 2, .. k} */
	   for(int k=0 ;k<V ;k++) 
		// Pick all vertices as source one by one
		 for(int i=0 ; i<V;i++)
			// Pick all vertices as destination for the
             // above picked source
			 for(int j=0 ;j<V;j++)
				 // If vertex k is on the shortest path from
                 // i to j, then update the value of dist[i][j]
				 if(dst[i][k] != Integer.MAX_VALUE && dst[k][j] != Integer.MAX_VALUE && dst[i][k]+dst[k][j]<dst[i][j])
					 dst[i][j]=dst[i][k]+dst[k][j];
	   // If distance of any vertex from itself
       // becomes negative, then there is a negative
       // weight cycle.
	   for(int i=0; i<V;i++)
		   if(dst[i][i]<0)
			   return true;
	   
	   return false;
   }
   //<--End of floyd Warshell Algorithm for detect negative Cycle
   
}
