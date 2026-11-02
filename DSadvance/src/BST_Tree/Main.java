package BST_Tree;

public class Main {
	//Binary search tree properties :
	   //1.The left subtree of a node contains
	   //only nodes with keys lesser than the node’s key.
		//2.The right subtree of a node contains
		//only nodes with keys greater than the node’s key.
		//3.The left and right subtree each
		//must also be a binary search tree.
		//There must be no duplicate nodes
		//(BST may have duplicate values with different handling approaches).
		// function to search a key in a BST
		public static Node searchKey(Node root,int key) {
			
			// Base Cases: root is null or key is present at
	        // root
			if(root==null || root.data==key)
				return root;
			 // Key is greater than root's key
			if(root.data<key) {
			  return	searchKey(root.right,key);
			}
			// Key is smaller than root's key
			else {
			  return	searchKey(root.left,key);
			}
	      		
	}
		// A utility function to insert a new node
	    // with the given key
		public static Node insert(Node root,int key) {
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
		//To delete a node in tree
		public static Node deleteNode(Node root,int key) {
			
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
		public static Node getsuccesor(Node root) {
			root=root.right;
			while(root!=null || root.left!=null) {
				root=root.left;
			}
			return root.left;
		}
		public static int height(Node root) {
			if(root==null) {
				return -1;
			}
			int lheight=height(root.left);
			int rheight=height(root.right);
			return Math.max(lheight,rheight)+1;
		}
		
		
		 public static void print(Node root) {
			 if(root==null)
				 return ;
			 print(root.left);
			 System.out.println(root.data+" ");
			 print(root.right);
			 
		 }
	     public static void main(String[] args) {
	    	// Creating a hard coded tree for keeping 
	         // the length of the code small. We need 
	         // to make sure that BST properties are 
	         // maintained if we try some other cases.
	    	 Node root = new Node(50);
	    	 root.left = new Node(30);
	    	 root.right= new Node(70);
	    	 root.left.left = new Node(20);
	    	 root.left.right = new Node(40);
	    	 root.right.left= new Node(60);
	    	 root.right.right= new Node(80);
	    	 
	    	 // Searching for keys in the BST
	    	 System.out.println("Original tree");
	    	 print(root);
	    	 System.out.println("searching in tree");
	    	 if(searchKey(root,40)!=null)
	    		 System.out.println("Key  found");
	    	 else
	    		 System.out.println("Key not found");
	    	 int key =10;
	    	 System.out.println("inserting "+key);
	    	 insert(root,key);
	    	 print(root);
	    	 //System.out.println("deleting "+key);
	    	 //deleteNode(root,key);
	    	 //print(root);
	    	 System.out.println(height(root));
		}
}
