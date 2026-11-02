package LinkedListDS;

public class Node {
	/*Inserting a new node in a doubly linked list
	 * is very similar to inserting new node in linked list.
	 * here is a little extra work required to maintain
	 * the link of the previous node
	 
	*/
	int data;
	Node next,prev;
	  
	  Node(int newData){
		  data = newData;
		  next=prev=null;
	  }
	
}
