package B_Tree;

public class Node {
	// Variables Declared
	int[] key;// Array to store keys
    int t; // Minimum degree (defines the range for number of keys)
    Node[] children; // Array to store child pointers
     int n ;// Current number of keys
     boolean leaf; // True when node is leaf, else False
   public Node(int t,boolean leaf) {
	   this.t=t;
	   key=new int[2*t-1];
	   children = new Node[2*t];
	   this.leaf=leaf;
	   n=0;
	   //A constructor to initialize btree node and keys
   }
   
// Function to search given key in subtree
   // rooted with this node
   public Node search(int key) {
	   int i=0;
	   while(i<n && key>this.key[i]) {
		   i++;
		   if(key==this.key[i])
			   return this;
		   if(leaf)
			   return null;
					   
	   }
	   return children[i].search(key);
	
   }
// Function to insert a new key
   // in subtree rooted with this node
   public void insertNonFull(int key) {
	   int i=n-1;
	   if(leaf) {
		   while(i>=0 && key<this.key[i]) {
			   this.key[i+1]=this.key[i];
			   i--;
		   }
		   this.key[i+1]=key;
		   n++;
	   }else {
		   while (i >= 0 && key < this.key[i])
               i--;
		  i++;
		  if(children[i].n==2*t-1) {
			  splitchild(i,children[i]);
			  if(key>this.key[i])
				  i++;
		  }
		  children[i].insertNonFull(key);
	   }
   }
// Function to split the child node
   public void splitchild(int i,Node y) {
	   Node z = new Node(y.t,y.leaf);
	   
	   for(int j =0;j<t-1;j++) {
		   z.key[j]=y.key[j+t];
	   }
	   
   }
     
}
