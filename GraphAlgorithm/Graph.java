package GraphAlgorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph {
  private CompetetiveProblem cp =new CompetetiveProblem();
	//parameters to represent a Graph (necessary)
  
  private List<List<Integer>> adl; //for adjacency list
  private List<List<Integer>> trl ;//for transpose list
  private int[][] adj;//for transpose adjacency matrix
  private int[][] trm;//for transpose adjacency matrix
  private int i;//to keep track of the indexes
  private int j;//same as i
  private int k;//same as j
   //Not initialized
   
   //------------->Constructors to initialize variables
  
  //for adjacency matrix 
  
   public Graph(int i,int j) {
	   this.i=i;
	   this.j=j;
	   adj= new int[this.i][this.j];
   }
   //for both adjacency list
   public Graph(int k) {
	   this.k=k;
	   adl=new LinkedList<>();
	   for(int x =0 ; x<this.k ;x++)
		   adl.add(new LinkedList<>());
	   adj =new int[this.k][this.k];
	  for(int i=0 ; i<this.k;i++)
		  for(int j=0; j<this.k;j++)
			  adj[i][j]=Integer.MAX_VALUE;
	   
   }
   //<--------------end of initialization
   //check if a graph has 0 nodes
   public boolean isEmpty() {
	   return this.k==0 ;
   }
   //----> Methods to add/remove edges on the matrix and adjacency List
   public void addWeightedEdge(int i,int j,int weight) {
	   adj[i][j]=weight;
   }
   public void addWeightedEdgeundirected(int i,int j,int weight) {
	   adj[i][j]=weight;
	   adj[j][i]=weight;
   }
   public void addEdge(int i,int j) {
	   adj[i][j]=1;
   }
   public void addEdgeUndirected(int i ,int j) {
	   adj[i][j]=1;
	   adj[j][i]=1;
   }
   public void addEdgeList(int i,int j) {
	   adl.get(i).add(j);
   }
   public void addEdgeListUndirected(int i,int j) {
	   adl.get(i).add(j);
	   adl.get(j).add(i);
   }
   public void removeEdge(int i,int j) {
	   adj[i][j]=0;
   }
   public void removeEdgeUndirected(int i,int j) {
	   adj[i][j]=0;
	   adj[j][i]=0;
   }
   public void removeEdgeList(int i ,int j) {
	   adl.get(i).remove(j);
   }
   public void removeEdgelistUndirected(int i,int j) {
	   adl.get(i).remove(j);
	   adl.get(j).remove(i);
   }
   public void removeWeightedEdge(int i,int j,int weight) {
	   adj[i][j]=0;
   }
   public void removeWeightedEdgeundirected(int i,int j,int weight) {
	   adj[i][j]=0;
	   adj[j][i]=0;
   }
   //<-------------------------end of methods to initialization
   
   //------->method to display adjacency matrix
   public void printlist() {
	   for(int i=0 ; i<adl.size();i++) {
		   System.out.print(i+"-->");
		   for(int j=0 ; j<adl.get(i).size();j++) {
			   if(j+1==adl.get(i).size())
			   System.out.print(adl.get(i).get(j));
			   else
			   System.out.print(adl.get(i).get(j)+"-->");
		   }
		   System.out.println();
	   }
	   System.out.println();
   }
   
   public void printMatrix(){
	   for(int i=0 ; i<adj.length;i++) {
		   for(int j=0 ; j<adj[i].length;j++)
			   System.out.print(adj[i][j]+" ");
		   System.out.println();
	   }
	   System.out.println();
   }
   //<-------------------------End of printing graph
   
   //------------------> BFS in graph
   // BFS is based on queue Data Structure
   //BFS Has 2 types 
   //1. BFS connected 2. BFS disconnected
   
   //s refers to the starting root 
   public void BreadthFirstSearch(int s) {//forConnected
	// Create a queue for BFS
	   Queue<Integer> q = new LinkedList<>();
       // Initially mark all the vertices as not visited
       // When we push a vertex into the q, we mark it as 
       // visited
	   boolean[] visited = new boolean[this.k];
       // Mark the source node as visited and enqueue it
        visited[s]=true;
        q.add(s);
	   while(!q.isEmpty()) {
		// Iterate over the queue
		// Dequeue a vertex and print it
		   int cur = q.poll();
		   System.out.print(cur + " ");
           // Get all adjacent vertices of the dequeued vertex
           // If an adjacent has not been visited, mark it 
           // visited and enqueue it
		   for(int x : adl.get(cur)) 
			   if(!visited[x]) {
				   visited[x]=true;
				   q.add(x);
			   }		   
	   }
	   System.out.println();
   }
   
   //2. BFS disconnected
   public void BFSdisconnected() {
	   boolean[] visited = new boolean[this.k];
	   for(int i=0 ; i<visited.length;i++)
		   if(!visited[i])
			   BFS(i,visited);
	   System.out.println();
   }
   //Helper BFS
   private void BFS(int s,boolean[] visited) {
	   Queue<Integer> q =new LinkedList<>();
	   visited[s]=true;
	   q.add(s);
	   while(!q.isEmpty()) {
		   int cur=q.poll();
		   System.out.print(cur+" ");
		   for(int x : adl.get(cur)) 
			   if(!visited[x]) {
				   visited[x]=true;
				   q.add(x);
			   }
		   
	   }
	   
   }
   
   //<------------------End of BFS
   
   //-------------------->DFS Traversal in Graph
   //DFS also 2 types it uses stack DataStructure
   //!. Connected DFS
   public void DepthFirstSearch(int s) {
	  boolean[] visited = new boolean[this.k];
	  Stack<Integer> stk = new Stack<>();
	  stk.push(s);
	  
	  while(!stk.isEmpty()) {
		  int cur = stk.pop();
		  if(!visited[cur]) {
			  System.out.print(cur+" ");
			  visited[cur]=true;
		  }
		  for(int neighbor : adl.get(cur))
			  if(!visited[neighbor])
				  stk.push(neighbor);		  
	  }
	  
	  System.out.println();
   }
   //2. DFS disconnected
   public void DFSdisconnected() {
	   boolean[] visited = new boolean[this.k];
	   for(int i=0;i<this.k;i++)
		   if(!visited[i])
		   DFS(i,visited);
	   System.out.println();
   }
   //Helper DFS method
   private void DFS(int s,boolean[] visited) {
	   Stack<Integer> stk = new Stack<>();
		  stk.push(s);
		  
		  while(!stk.isEmpty()) {
			  int cur = stk.pop();
			  if(!visited[cur]) {
				  System.out.print(cur+" ");
				  visited[cur]=true;
			  }
			  for(int neighbor : adl.get(cur))
				  if(!visited[neighbor])
					  stk.push(neighbor);		  
		  }
		  
   }
   //<----------------------End of DFS

   //---------------> detect cycle in a directed graph
   //Using DFS
   public boolean isCyclic() {
	   boolean[] visited = new boolean[this.k];
	   boolean[] recstk= new boolean[this.k];
	   // Call the recursive helper function to 
       // detect cycle in different DFS trees
	   for(int  i=0 ; i<this.k;i++) 
		if(!visited[i] && isCyclictil(i,visited,recstk))
			return true;
			
	   return false;
   }
   boolean isCyclictil(int u,boolean[] visited,boolean[] recstk) {
	   if(!visited[u])
	   {
		// Mark the current node as visited 
           // and part of recursion stack
		   visited[u]=true;
		   recstk[u]=true;
		   // Recur for all the vertices adjacent
           // to this vertex
		   for(int x :adl.get(u)) 
			   if(!visited[x] && isCyclictil(x,visited,recstk))
				   return true;
			   else if(recstk[x])
				   return true;
		   
	   }
	   return false;
   }
   //using BFS 
   boolean detectcycle() {
	   //store in degree of each vertex
	   int[] d = new int[this.k];
	// Queue to store vertices with 0 in-degree
	   Queue<Integer> q = new LinkedList<>();
	   int visit =0;
	// Calculate in-degree of each vertex
	   for(int i=0 ; i<this.k;i++)
		   for(int x : adl.get(i))
			   d[x]++;
	// Enqueue vertices with 0 in-degree
	   for(int i=0 ; i<this.k;i++) {
		   if(d[i]==0)
			   q.add(i);
	   }
	// BFS traversal
	   while(!q.isEmpty()) {
		   int u=q.poll();
		   visit++;
           // Reduce in-degree of adjacent vertices
		   for(int x : adl.get(u)) {
			   d[x]--;
               // If in-degree becomes 0, enqueue it
			   if(d[x]==0)
				   q.add(x);
		   }
	   }
	// If not all vertices are visited, cycle
	   return visit!=this.k;
   }
   //<----------------------------end of detection of cycle directed
   //---------------->detection cycle in undirected graph
   //using DFS
   // A recursive function that
   // uses visited[] and parent to detect
   // cycle in subgraph reachable
   // from vertex v.
   private boolean isCyclicUtil(boolean[] visited, int parent, int v) {
       // Mark the current node as visited
       visited[v] = true;

       // Recur for all the vertices adjacent to this vertex
       for (int x : adl.get(v)) {
           // If an adjacent vertex is not visited, then recur for that adjacent
           if (!visited[x]) {
               if (isCyclicUtil(visited, v, x)) {
                   return true;
               }
           }
           // If an adjacent vertex is visited and is not parent of current vertex,
           // then there exists a cycle in the graph.
           else if (x != parent) {
               return true;
           }
       }

       return false;
   }

   // Returns true if the graph contains a cycle, else false.
   public boolean isCyclicdirected() {
       // Mark all the vertices as not visited
       boolean[] visited = new boolean[this.k];

       // Call the recursive helper function to detect cycle in different DFS trees
       for (int i = 0; i < this.k; i++) {
           // Don't recur for u if it is already visited
           if (!visited[i]) {
               if (isCyclicUtil(visited, -1, i)) {
                   return true;
               }
           }
       }
       return false;
   }
   
   //<--------end of method
   
   
   // method from Competitive program class
   public int countIsland() {
	   return cp.countIsland(adj);
   }
   public void floodFill(int x,int y,int newcl) {
	   cp.floodFill(adj, x, y, newcl);
   }
   public boolean isBipertite() {
	   //return cp.isBipertite(adl, this.k);
	   return cp.iSbipertite(adl, this.k);
   }
   public boolean containsNegativeCycle() {
	   return cp.detectNegativeCycle(adj);
   }
   public int countNumberOfCycle(int n) {
	   return cp.countCycle(adj, n);
   }
   public boolean containsNegativeCycleFW() {
	   return cp.neagtiveCycleFloydWarshell(adj);
   }
   //<---------above all are the cp methods
   //---------->Shortest path algorithms
   private Shortestpath s = new Shortestpath();
   public void dijkstra(int src) {
	   s.dijkstrageeks(adj, src);
	   //s.Dijkstra(adj, src);
   }
   public void bellmanford(int src ,int[][] te,int v) {
	   int[] temp= s.bellmanford(te,src ,v );
     for(int t :temp)
    	 System.out.print(t+" ");
    	 System.out.println();
   }
   public void floydWarshell(int [][]a) {
	   s.floydShortestPath(a);
   }
   //<---------Ending of Shortest path Algorithms
}
