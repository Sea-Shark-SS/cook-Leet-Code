package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
      //Necessary parameters to represent a graph
	   int[][] adj;//adjacency matrix
       int[][] tc ; //transpose matrix
       int i;
       int j;
       int k;
       List<List<Integer>> adl;//adjacency list
       List<List<Integer>> tr;//transpose list
       // not initialized 
       
       //method to find if a graph has value
       public boolean isEmpty() {
    	   return (this.k==0);
       }
       
       //---> Constructor to initialize the parameters
       public Graph(int i ,int j) {
    	   this.i=i;
    	   this.j=j;
    	     adj = new int[this.i][this.j];
         }
       public Graph(int i) {
    	   this.k=i;
    	   adl = new LinkedList<>();
    	   for(int x =0;x<k;x++)
    		   adl.add(new LinkedList<>());
    	  tc = new int[this.k][this.k];
       }
       //<-----end of initialization
       
       //----> Methods to add/remove edges on the matrix and adjacency List
       
       public void addEdge(int i , int j) {
    	   //for undirected graph
    	   //adj[i][j]=1;
    	   //adj[j][i]=1;
    	   //for directed graph
    	   adj[i][j]=1;
       }
       public void addEdgeUndirected(int i , int j) {
    	   //for undirected graph
    	   adj[i][j]=1;
    	   adj[j][i]=1;
    	   //for directed graph
    	   //adj[i][j]=1;
       }
       public void removeEdge(int i,int j) {
    	   adj[i][j]=0;
       }
       public void removeEdgeUndirected(int i,int j) {
    	   adj[i][j]=0;
    	   adj[j][i]=0;
       }
       public void addEdgeListUndirected(int i,int j) {
    	   adl.get(i).add(j);
    	   adl.get(j).add(i);
      }
      public void removeEdgeListUndirected(int i,int j) {
    	  adl.get(i).remove(j);
    	  adl.get(j).remove(i);
      }
       public void addEdgeList(int i,int j) {
    	   adl.get(i).add(j);
      }
      public void removeEdgeList(int i,int j) {
    	  adl.get(i).remove(j);
      }
       
       //<-----end of add/remove method
       
       //------->method to display adjacency matrix
       public void displayMatrix() {
    	   for(int i =0;i<this.i;i++) {
    		   for(int j=0;j<this.j;j++) {
    			   System.out.print(adj[i][j]+" ");
    		   }
    		   System.out.println();
    	   }
       }
       //<------end of method
       
       //------->method to display adjacency List
        public void displayList() {
    	   for(int i=0;i<adl.size();i++) {
    		   System.out.print(i+": ");
    		   for(Integer x : adl.get(i)) {
    			   System.out.print(x+" ");
    		   }
    		   System.out.println();
    	   }
       }
       //<----end of method
     
       //--------> methods for transpose list of a graph
    void addtredge(int i,int j) {
    	tr.get(i).add(j);
    }
   void transpose() {
	tr = new LinkedList<>();
	for(int i=0;i<adl.size();i++) {
		tr.add(new LinkedList<>());
	}
	for(int i=0;i<adl.size();i++) {
		for(int j=0;j<adl.get(i).size();j++) {
			addtredge(adl.get(i).get(j),i);
		}
	}
   }
   void printTranspose() {
	   for(int i=0;i<tr.size();i++) {
		   System.out.print(i+": ");
		   for(int j=0 ; j<tr.get(i).size();j++) {
			   System.out.print(tr.get(i).get(j)+" ");
		   }
		   System.out.println();
	   }
   }
   //<---- print method 
   
 //------->BFS for  a graph if the root is given
   //print of graphs and transposes
   //adding edges as adjacent list and adjacency list
   //BFS in a graph that is connected
   void BFSGraph(int s) {
	 //function to bfs in a graph s is the root
	// Create a queue for BFS
	 Queue<Integer> q = new LinkedList<>();
     // Initially mark all the vertices as not visited
    boolean[] visited = new boolean[adl.size()];
    // Mark the source node as visited and enqueue it
   visited[s]=true;
	 q.add(s);
	 
	 // Iterate over the queue
	 while(!q.isEmpty()) {
		// Dequeue a vertex and print it
		 int v=q.poll();
		 System.out.print(v+" ");
      // Get all adjacent vertices of the dequeued vertex
      // If an adjacent has not been visited, mark it 
		 // visited and enqueue it
		 for(int x : adl.get(v)) {
			 if(!visited[x]) {
		
				 visited[x]=true;
				 q.add(x);
			 }
		 } 
	 }
	 
   }
     
   // <-------end of method
   
   //check if a node Level
   int checkNodeLevel(int s) {
		int max=this.k;
       if(s>max || adl.size()==0) {
    	   return -1;
       }
		 int count=0;
		 	 Queue<Integer> q = new LinkedList<>();
		     boolean[] visited = new boolean[adl.size()];
		  visited[0]=true;
			 q.add(0);
		while(!q.isEmpty()) {
			int a=q.size();
			while(a-->0) {
		 int v=q.poll();
		 if(v==s)
	    	   return count;
		 for(int x : adl.get(v)) {
					 if(!visited[x]) {
				       
				 visited[x]=true;
				 q.add(x);
					 }
				 }
			 }
			count++;
		}
		return -1;	 
			 
   }
   //<-------end of check node Level method
   
   //----->Method to check if a node can visit all the Nodes
   public boolean canVisitAllNode(int x) {
	   Queue<Integer> q = new LinkedList<>();
	   boolean[] visited = new boolean[adl.size()];
	   visited[x]=true;
	   q.add(x);
	   int count=0;
	   while(!q.isEmpty()) {
		   
			 int v=q.poll();
			 for(int s : adl.get(v)) {
				 if(!visited[s]) {
					 visited[s]=true;
					 q.add(s);
					 count++;
				 }
			 }
   }
	   return (count+1==adl.size());
   }
   //<---- end of method
   
   //--------> BFS sample for a graph
   public void BFSGraphD(int s,boolean[] visit) {
	   Queue<Integer> q = new LinkedList<>();
	   q.add(s);
	   visit[s]=true;
	   while(!q.isEmpty()) {
	    	int v= q.poll();
	    	System.out.print(v+" ");
	    	for(int x :adl.get(v)) {
	    		if(!visit[x]) {
	    			visit[x]=true;
	    			q.add(x);
	    		}
	    	}
	    }
   }
   public void BFSDisconnected() {
	   boolean[] visit = new boolean[adl.size()];
	   //if any node is disconnected from the source or 
	   // its adjacents then use this method
	   for(int i=0;i<visit.length;i++) {
		   if(!visit[i]) {
			   visit[i]=true;
			   BFSGraphD(i,visit);
		   }
	   }
	   
   }
   //<------- end of BFS sample
   
   //----> DFS sample for a graph
   public void DFSsearch(int s) {
	   boolean[] visit =  new boolean[adl.size()];
	   DFS(visit,s);
   }
   // ---- for Disconnected graph
   public void DFSdisConnectedSearch(int s) {
	   boolean[] visit =  new boolean[adl.size()];
	   for(int i=0;i<visit.length;i++) {
		if(!visit[i]) {
			DFS(visit,i);
		}
	   }
	   
   }
   public void DFS(boolean[] visited,int s) {
	    visited[s]=true;
	   System.out.print(s+" ");
	   for(int x : adl.get(s)) {
		   if(!visited[x]) {
			   DFS(visited,x);
		   }
	   }
   }
   
  //<---- end of sample DFS in a graph
   
   
   //--------->Transitive Closure for a graph
   
// A recursive DFS traversal
   // function that finds
   // all reachable vertices for s
   public void dfstill(int i,int j) {
	   if(i==j) {
		   tc[i][j]=1;
	   }else {
		   tc[i][j]=1;
	   }
	   
	// Find all the vertices reachable
       // through v
	 for(int x : adl.get(j)) {
		 if(tc[i][x]==0) {
			 dfstill(i,x);
		 }
	 }
	   
   }
   
   // The function to find transitive
   // closure. It uses
   // recursive DFSUtil()
   public void transitiveClosure() {
	// Call the recursive helper
    // function to print DFS
    // traversal starting from all
    // vertices one by one
	   for(int i=0;i<this.k;i++) {
		   dfstill(i,i);
	   }
	   
	   for(int i=0;i<this.k;i++) {
       for(int j=0;j<this.k;j++) {
    	   System.out.print(tc[i][j]+" ");
       }
       System.out.println();
	   }
   }
   
   //<-------end of transitive closure method
   
   
    //Kosaraju's algorithm --->
   //step 1
    public void dfsforscc(boolean[] visited,int s,Stack<Integer> st) {
	    visited[s]=true;
	   
	   for(int x : adl.get(s)) {
		   if(!visited[x]) {
			   dfsforscc(visited,x,st);
		   }
	   }
	   st.push(s);
   }
    
    public List<List<Integer>> kosaraju(){
    	Stack<Integer> stack = new Stack<>();
    	boolean[] visited = new boolean[adl.size()];
    	// Step 1: Perform DFS on the original graph
    	for(int i=0;i<visited.length;i++) {
    		if(!visited[i])
    		dfsforscc(visited,i,stack);
    	}
    	// Step 2: Transpose the graph
        Graph g= transposes();
        
     // Step 3: Perform DFS on the transposed graph
        visited = new boolean[adl.size()];
        List<List<Integer>> sccs=new LinkedList<>();
        while(!stack.isEmpty()) {
        	int v = stack.pop();
        	if(!visited[v]) {
        		List<Integer> scc = new LinkedList<>();
        		g.dfsTransposed(v,visited,scc);
        		sccs.add(scc);
        	}
        }
    	return sccs;
    }
    //step 3
    public void dfsTransposed(int v, boolean[] visited, List<Integer> scc) {
    	visited[v]=true;
    	scc.add(v);
    	for (int neighbor : adl.get(v)) {
            if (!visited[neighbor]) {
                dfsTransposed(neighbor, visited, scc);
            }
        }
    }
    //step 2
    public Graph transposes() {
        Graph transposedGraph = new Graph(this.k);
        for (int u = 0; u < this.k; u++) {
            for (int v : adl.get(u)) {
                transposedGraph.addEdgeList(v, u);
            }
        }
        return transposedGraph;
    }
    //<------ kosaraju's algorithm
 
    //------->Tarjan's algorithm
 // Method to find all strongly connected components in the graph
 
    public List<List<Integer>> tarjan() {
        int n = adl.size();
        int[] indices = new int[n];
        int[] lowLink = new int[n];
        boolean[] onStack = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> sccs = new ArrayList<>();
        Arrays.fill(indices, -1); // Mark all nodes as unvisited
        int[] index = {0}; // Use an array to allow modification in dfs

        // Perform DFS for each unvisited node
        for (int v = 0; v < n; v++) {
            if (indices[v] == -1) {
                dfs(v, indices, lowLink, onStack, stack, sccs, index);
            }
        }
        return sccs;
    }

    // Depth-First Search method to explore the graph and find SCCs
    private void dfs(int v, int[] indices, int[] lowLink, boolean[] onStack, Stack<Integer> stack, List<List<Integer>> sccs, int[] index) {
        indices[v] = lowLink[v] = index[0]++; // Set index and low-link value
        stack.push(v); // Push the node onto the stack
        onStack[v] = true; // Mark the node as being on the stack

        // Explore all adjacent nodes
        for (int w : adl.get(v)) {
            if (indices[w] == -1) {
                // If w has not been visited, recurse on it
                dfs(w, indices, lowLink, onStack, stack, sccs, index); // Pass parameters
                lowLink[v] = Math.min(lowLink[v], lowLink[w]); // Update low-link value
            } else if (onStack[w]) {
                // If w is on the stack, it's part of the current SCC
                lowLink[v] = Math.min(lowLink[v], indices[w]); // Update low-link value
            }
        }

        // If v is a root node, pop the stack and generate an SCC
        if (lowLink[v] == indices[v]) {
            List<Integer> scc = new ArrayList<>();
            int w;
            do {
                w = stack.pop(); // Pop from the stack
                onStack[w] = false; // Mark it as not on the stack
                scc.add(w); // Add to the current SCC
            } while (w != v);
            sccs.add(scc); // Add the found SCC to the list
        }
    }

    //<------ end of Tarjan's Algorithm
    
    //-------> detect cycle in a directed Graph using DFS
    // DFS -> Depth First Search
    // Utility function to detect cycle in a directed graph
    private boolean isCyclicUtil(int u,boolean[] visited,boolean[] recStack) {
    	if(!visited[u]) {
    		// Mark the current node as visited 
            // and part of recursion stack
    		visited[u]=true;
    		recStack[u]=true;
    		
    		// Recur for all the vertices adjacent
            // to this vertex
    		for(int x :adl.get(u)) {
    			if(!visited[x] && isCyclicUtil(x,visited,recStack)) {
    				return true;
    			}else if(recStack[x]) {
    				return true;
    			}
    		}
    	}
    	 // Remove the vertex from recursion stack
    	recStack[u]=false;
    	return false;
    }
    // Function to detect cycle in a directed graph
    public boolean isCyclicDirected() {
    	boolean[] visited = new boolean[this.k];
    	boolean[] recStack = new boolean[this.k];
    	
    	// Call the recursive helper function to 
        // detect cycle in different DFS trees
    	for(int i=0;i<this.k;i++) {
    		if(!visited[i] && isCyclicUtil(i,visited,recStack)) {
    			return true;
    		}
    	}
    	return false;
    }
    //<-------- end of isCyclic method
    
    //----------->Finding cycle is an undirected graph using DFS
    // A recursive function that
    // uses visited[] and parent to detect
    // cycle in subgraph reachable
    // from vertex v.
    
    // --supportive method to check edges if there is a cycle--
    private boolean isCyclicUtil(int v,boolean[] visited, int parent) {
    	// Mark the current node as visited
    	visited[v]=true;
    	// Recur for all the vertices
        // adjacent to this vertex
    	for(int i : adl.get(v)) {
    		// If an adjacent vertex is not visited,
            // then recur for that adjacent
    		if(!visited[i] && isCyclicUtil(i,visited,v)) {
    			return true;
    		}

            // If an adjacent vertex is visited and
            // is not parent of current vertex,
            // then there exists a cycle in the graph.
    		else if(i!=parent)
    			return true;
    	}
    	return false;
    }
    // -->method to check if graph has cycle or not<--
    // Returns true if the graph contains
    // a cycle, else false.
    public boolean isCyclicUndirected() {
    	// Mark all the vertices as not visited
    	boolean[] visited = new boolean[this.k];
    	 // Call the recursive helper function
        // to detect cycle in different DFS trees
    	for(int i=0;i<this.k;i++) {
            // Don't recur for u if it is already visited
          if(!visited[i] && isCyclicUtil(i,visited,-1))
        	  return true;
    	}
    	return false;
    }
    //DFS traversal for finding if graph has cycle
    //<------end of method 
    
    
    
}
