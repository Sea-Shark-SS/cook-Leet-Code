package SetDataStructure;


public class Treeset implements Set {
	class Node{
		int data;
		Node left;
		Node right;
		public Node(int data) {
			this.data=data;
			left=right=null;
		}
	}
	Node root =null;
public Node deleteNode(Node root,int key) {
		
		// given BST  and returns the modified root of 
	    // the BST (if it is modified).
		// Base case
		if(root==null)
			return root;
		 // If key to be searched is in a subtree
		if(key<root.data)
		{
			root.left = deleteNode(root.left,key);
		}else if(key>root.data) {
			root.right= deleteNode(root.right,key);
		}
		else {
			 // If root matches with the given key

            // Cases when root has 0 children or
            // only right child
			if(root.left==null)
				return root.right;
			
			// When root has only left child
			if(root.right==null)
				return root.left;
			
			 // When both children are present
			Node cur = getsuccesor(root);
			root.data=cur.data;
			root.right=deleteNode(root.right,cur.data);
     	}
		return root;
	}
	// Note that it is not a generic inorder successor 
    // function. It mainly works when the right child
    // is not empty, which is the case we need in BST
    // delete. 
	public  Node getsuccesor(Node root) {
		root=root.right;
		while(root!=null || root.left!=null) {
			root=root.left;
		}
		return root.left;
	}
	public Node insert(Node root,int key) {
		//A new key is always inserted at the leaf. 
		// Start searching a key from the root till a leaf node
		// Once a leaf node is found,
		//the new node is added as a child of the leaf node.
        // If the tree is empty, return a new node
		
		if(root==null) {
			
		root = new Node(key);
		   return root;
		}
		// If the key is already present in the tree,
        // return the node
		if(root.data==key) {
			return root;
		}
		 // Otherwise, recur down the tree
		if(root.data>key) {
			root.left = insert(root.left,key);
		}
		else {
			root.right= insert(root.right,key);
		}
		//insert is done
		//BigO(1)
		// Return the (unchanged) node pointer
		return root;
	}
       public void add(int data) {
		root=insert(root,data);
	   }
	   public void remove(int key) {
		root=deleteNode(root,key);
	   }
	   public void removeAll() {
		   root=null;
	   }
	   public boolean searchKey(Node root,int key) {
		   if(root==null)
				return false;
			// Base Cases: root is null or key is present at
	        // root
		   if(root.data==key)
			   return true;
			
			 // Key is greater than root's key
			if(root.data<key) {
			  return	searchKey(root.right,key);
			}
			// Key is smaller than root's key
			else {
			  return	searchKey(root.left,key);
			}
	      		
	}
	   public boolean contains(int x) {
		   return searchKey(root,x);
	   }
	   int max(Node root) {
		  if(root==null)
			  return 0;
		  
		  if(root.right==null)
			  return root.data;
		  else {
			  return max(root.right);
		  }
	   }
	   
	   public int maxValue() {
		   return max(root);
	   }
	   int min(Node root) {
			  if(root==null)
				  return 0;
			  
			  if(root.left==null)
				  return root.data;
			  else {
				  return min(root.left);
			  }
		   }
	   public int minValue() {
		   return min(root);
	   }
	   int preOrder(Node root) {
		   if(root==null)
			   return 0;
		   return 1+preOrder(root.left)+preOrder(root.right);
	   }
	   public int sizeOfSet() {
		   return preOrder(root);
	   }
	   public boolean isEmpty() {
		   return (root==null);
	   }
	   void inOrder(Node root) {
		   if(root==null)
			   return;
		   inOrder(root.left);
		   System.out.print(root.data+" ");
		   inOrder(root.right);
	   }
	void print() {
		inOrder(root);
	}
	   
}
