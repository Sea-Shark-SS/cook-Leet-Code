package TreeDATASTRUCTURE;

import java.util.LinkedList;

import java.util.Queue;

public class Main {
    //1. Traversal in Binary Tree
    // In-order DFS: Left, Root, Right
    public static void inOrder(Node node){
    if(node==null)
        return;
    inOrder(node.left);
        System.out.println(node.data+" ");
    inOrder(node.right);
    }
    public static void preOrder(Node node){
        if(node==null)
            return;
        System.out.println(node.data);
        preOrder(node.left);
        preOrder(node.right);
    }
    public static void postOrder(Node node){
        if(node==null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.data+" ");

    }
    public static void BFS(Node root){
        if(root==null)
            return;
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.poll();
            System.out.println(node.data+" ");
            if(node.left!=null)
                q.add(node.left);
            if(node.right!=null)
                q.add(node.right);
        }

    }
    //inserting in a tree
    // Function to insert a new node in the binary tree
    public static Node insert(Node root,int key) {
  	  //if tree is empty
  	  if(root==null)
  	  {
  		  return new Node(key);
  	  }
  	// Create a queue for level order traversal
  	  Queue<Node> q = new LinkedList<>();
  	  q.add(root);
  	  while(!q.isEmpty()) {
  		  Node temp = q.poll();
  		  // If left child is empty, insert the new node here
  		  if(temp.left==null) {
  			  temp.left =new Node(key);  
  		      break;
  		  }else {
  			  q.add(temp.left);
  		  }
  			
  		  //if right child is empty
  		  if(temp.right==null) {
  			  temp.right=new Node(key);
  			  break;
  			  }else {
  				  q.add(temp.right);
  			  }
  	  }
  	  return root;
    }
    public static boolean search(Node root,int key) {
  	  //to search in a binary tree
  	// Base case: If the tree is empty or we've reached
        // a leaf nod
  	  if(root==null)
  		  return false;
  	  // If the node's data is equal to the value we are
        // searching for
  	  if(root.data==key)
  		  return true;
  	  // Recursively search in the left and right subtrees
  	  boolean leftsearch = search(root.left,key);
  	  boolean rightsearch = search(root.right,key);
  	  
  	  return leftsearch || rightsearch;
    }
    public static Node delete(Node root,int key) {
  	  if (root == null)
  		  return null;
  	  // Use a queue to perform BFS
  	  Queue<Node> q =new LinkedList<>();
  	  q.add(root);
  	  Node target =null;
  	// Find the target node
  	  while(!q.isEmpty()) {
  		  Node cur = q.poll();
  		  if(cur.data==key) {
  			  target=cur;
  			  break;
  		  }else {
  			  if(cur.left!=null)
  				  q.add(cur.left);
  			  if(cur.right!=null)
  				  q.add(cur.right);
  		  }
  	  }
  	  if(target==null)
  		  return root;
  	// Find the deepest rightmost node and its parent
  	  Node lastnode = null;
  	  Node lastparent = null;
  	  Queue<Node> ln = new LinkedList<>();
  	  Queue<Node> lp = new LinkedList<>();
  	  ln.add(root);
  	  lp.add(null);
  	  while(!ln.isEmpty()) {
  		  Node cur = ln.poll();
  		  Node parent = lp.poll();
  		lastnode = cur;
  		lastparent=parent;
  		if(cur.left!=null) {
  			ln.add(cur.left);
  			lp.add(cur);
  		}
  		if(cur.right!=null) {
  			ln.add(cur.right);
  			lp.add(cur);
  		}
  	}
  	// Replace target's value with the last node's value
  	target.data=lastnode.data;
      // Remove the last node
  	if(lp!=null) {
  		if(lastparent.left==lastnode)
  			lastparent.left=null;
  		else
  			lastparent.right=null;
  	} else
			return null;
  	
  	  return root;
    }
    public static void main(String[] args) {

    	Node root = new Node(2);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(5);
		System.out.println("before insertion");
		System.out.println("inOrder treverse ");
		inOrder(root);
		System.out.println();
		System.out.println("preOrder treverse");
		preOrder(root);
		System.out.println();
		System.out.println("postOrder treverse");
		postOrder(root);
		System.out.println();
		 System.out.println("BFS order");
		 BFS(root);
		 System.out.println();
	     int key = 6;
	     System.out.println("After insertion");
	     insert(root,key);
	     System.out.println("inOrder treverse ");
		inOrder(root);
		System.out.println();
		System.out.println("preOrder treverse");
		preOrder(root);
		System.out.println();
		System.out.println("postOrder treverse");
		postOrder(root);
		System.out.println();
		System.out.println("BFS order");
		BFS(root);
		System.out.println();
		System.out.println(key+" is in tree? "+search(root,key));
        System.out.println("after Delete "+key);
        delete(root,key);
        System.out.println("inOrder treverse ");
		inOrder(root);
		System.out.println();
		System.out.println("preOrder treverse");
		preOrder(root);
		System.out.println();
		System.out.println("postOrder treverse");
		postOrder(root);
		System.out.println();
		System.out.println("BFS order");
		BFS(root);
		System.out.println();
		
        
    }

}