package Sort;

import java.util.ArrayList;

public class Treesort {
static class Node{
	int data;
	Node left;
	Node right;
	public Node(int data) {
		this.data=data;
		this.left=null;
		this.right=null;
	}
}


  static ArrayList<Integer> l = new ArrayList<>() ;
   static Node createTree(int a[]) {
	   Node root = null;
	   for(int i=0 ; i<a.length;i++)
		   root = insert(root , a[i]);
	   
		   return root;
   }
   static Node insert(Node root, int key) {
	   if(root==null)
		   return new Node(key);
	   
	   if(root.data>key)
		  root.left= insert(root.left,key);
	   else
		  root.right=insert(root.right,key);
	   return root;
   }
   
   static void inOrder(Node root) {
	   if(root==null)
		   return;
	   inOrder(root.left);
	    l.add(root.data);
	   inOrder(root.right);
   }
   
   public static void printArray(int ar[]) {
		for(int i =0 ; i<ar.length;i++)
			System.out.print(ar[i]+" ");
		System.out.println();
	}
  
    public static void main(String[] args) {
    	int [] ar = {25,6,20,10,12,14,16,2,8,4,3,5,9,1};
		System.out.println("Before sorting");
		printArray(ar);
		Node root ;
		root = createTree(ar);
		inOrder(root);
		System.out.println("After sorting");
		for(int i=0 ; i<l.size();i++)
			ar[i]=l.get(i);
		printArray(ar);
   }
}
