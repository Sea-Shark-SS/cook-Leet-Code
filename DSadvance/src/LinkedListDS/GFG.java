package LinkedListDS;

public class GFG {
	
	// Function to insert a new node at the front of
    // doubly linked list
	public static Node insertAtFront (Node head,int newdata) {
		//crate a new Node
		//Big-O (1) Aux space O(1)
		Node newNode = new Node(newdata);
		//Make next of new Node as head
		newNode.next=head;
		// Change prev of head node to new node
		if(head!=null)
			head.prev=newNode;
		// Return the new node as the head of the doubly
        // linked list
		return newNode;
	}
	 // Function to print the doubly linked list
	public static void printlist(Node head) {
		Node cur = head;
		while(cur!=null) {
			System.out.print(cur.data+" ");
		   cur = cur.next;
		}
		System.out.println();
		
	}
	
	// Function to insert a new node after a given node 
	 //in the doubly linked list
	public static Node insertAfter(Node head,int key,int newData) {
		Node cur = head;
		//Big-O (n) Aux space O(1)
		// Iterate over Linked List to find the key
		 while (cur != null) {
	            if (cur.data == key)
	                break;
	            cur = cur.next;
	        }
		// If curr becomes null, the given 
		 //key is not found in the linked list
		 if(cur==null)
			 return head;
		 //create a new Node
		 Node newNode = new Node(newData);
		// Set prev of new node to the given node
		 newNode.prev=cur;
		 // Set next of new node to the next of the given node
		 newNode.next=cur.next;
		// Update next of the given node to new node
		 cur.next=newNode;
		 // Update the prev of new node's next with the new node
		 if (newNode.next != null)
	            newNode.next.prev = newNode;
		 return head;
		 
		 
	}
	// Function to insert a new node before a given node
	 public static Node insertBefore(Node head,int key , int newData) {
		Node cur = head;
		//Big-O (n) Aux space O(1)
		 // Iterate over Linked List to find the key
        while (cur != null) {
            if (cur.data == key) {
                break;
            }
            cur = cur.next;
        }
        // If cur becomes null, the given key is not found
        // in the linked list
        if (cur == null) {
            return head;
        }
        //create a new node
        Node newNode = new Node(newData);
     // Set prev of new node to prev of given nod
        newNode.prev=cur.prev;
     // Set next of new node to given node
        newNode.next=cur;
     // Update next of given node's prev to new node
        if (cur.prev != null) {
            cur.prev.next = newNode;
        }
        else {
            // If the current node is the head, update the head
            head = newNode;
        }
        // Update prev of given node to new node
        cur.prev=newNode;
        return head;
        
     }
	 //To insert a new node at a specific position
	 public static Node insertAtPosition(Node head,int pos,int newData) {
		// Function to insert a new node at a given position
		 // Create a new node
		//Big-O (n) Aux space O(1)
		 Node newNode = new Node(newData);
		// Insertion at the beginning
		 //1.Traverse the list to position –> 1.
		 if(pos==1) {
			 newNode.next=head;
		 // If the linked list is not empty,
		 // set the prev of head to new node
		 if(head!=null)
			 head.prev=newNode;
		// Set the new node as the head of linked list
		 head=newNode;
		 
		 return head;
		 }
		 Node cur=head;
		 //2.If the position is valid, update the next pointer
		 // of new node to the next of current node
		 // and prev pointer of new node to the current node.
		// Traverse the list to find the node before the insertion point
		 for (int i = 1; i < pos - 1 && cur != null; ++i) {
	            cur = cur.next;
	        }
		// If the position is out of bounds
		 if(cur==null) {
			 System.out.println("Out of Bound");
		     return head;
		 }
		 //Similarly, update next pointer of current node 
		 //to the new node and prev pointer of 
		 //new node’s next to the new node.
		 // Set the prev of new node to curr
		 newNode.prev=cur;
		// Set the next of new node to next of curr
		 newNode.next=cur.next;
		// Update the next of current node to new node
		 cur.next=newNode;
		 // If the new node is not the last node,
		 // update prev of next node to new node
		 if(newNode.next!=null) {
			 newNode.next.prev=newNode;
		 }
		 // Return the head of the doubly linked list
		 return head;
	 }
	 //To insert a new node at the end
	// Function to insert a new node at the end of the
	    // doubly linked list
	 public static Node insertAtEnd(Node head,int newData) {
		 // Create a new node
		 //Big-O (n) Aux space O(1)
		 Node newNode= new Node(newData);
		// If the linked list is empty, set the new node as
	        // the head
		 if(head==null)
		    head=newNode;
		 else {
			 Node cur =head;
			 while(cur.next!=null) {
				 cur=cur.next;
			 }
			// Set the next of last node to the new node
			 cur.next=newNode;
			// Set the prev of new node to the last node
			 newNode.prev=cur;
		 }
		 return head;
	 }
	// Function to delete the first node (head) of the
	// list and return the second node as the new head
	 public static Node deleteHead(Node head) {
		 // If empty, return null
		 if(head==null)
			 return null;
		  // Store in temp for deletion later
		 Node temp = head;
		// Move head to the next node
		 head=head.next;
		// Set prev of the new head
		 if(head!=null) {
			 head.prev=null;
		 }
		  // Return new head
		 return head;	 
	 }
	// Function to delete a node after a given node in
	    // doubly linked list
	 public static Node deleteAfter(Node head,int key) {
		 Node cur=head;
		// Iterate over Linked List to find the key
		 while(cur!=null) {
			 if(cur.data==key) {
				 break;
			 }//treversing through a linked list to find key
			 cur=cur.next;
		 }
		// If curr is null or curr.next is null, there is no
	        // node to delete
		 if(cur==null || cur.next==null)
			 return head;
		// Node to be deleted
		 Node nodeDelete = cur.next;
		// Update the next of the current node to the next
	        // of the node to be deleted
		 cur.next=nodeDelete.next;
		// If the node to be deleted is not the last node,
	        // update the previous pointer of the next node
		 if(nodeDelete.next!=null)
			 nodeDelete.next.prev=cur;
		 		 
		 return head;
	 }
	// Function to delete a node before a given node in a
	    // doubly linked list
	 public static Node deleteBefore(Node head,int key) {
		 //create a cur node
		 Node cur = head;
		 //iterate to find the key
		 while(cur!=null) {
			 if(cur.data==key)
				 break;
		  cur=cur.next;	 
		 }
		 //If curr is null or curr.prev is null, there is no
	        // node to delete
		 if(cur==null || cur.prev==null)
			 return head;
		 // Node to be deleted
		 Node nodeDelete = cur.prev;
		// Update the prev of the current node to the prev
	        // of the node to be deleted
		 cur.prev=nodeDelete.prev;
		// If nodeToDelete's prev is not null, update its
	        // next pointer to the current node
		 if(nodeDelete.prev!=null)
			 nodeDelete.prev.next=cur;
		 else {
			 // If nodeToDelete is the head node
		   head=cur;
		 }
		 
		 return head;
	 }
	 public static Node deleteAtPosition(Node head,int pos) {
		 
		 // If the list is empty
	        if (head == null) {
	            return head;
	        }
	        Node cur=head;
		 //iteerate to find the position
	        for (int i = 1; cur != null && i < pos; ++i) {
	            cur = cur.next;
	        }
	        // If the position is out of range
	        if(cur==null)
	        	return head;
	     // Update the previous node's next pointer
	        if(cur.prev!=null)
	        	cur.prev.next=cur.next;
	     // Update the next node's prev pointer
	        if(cur.next!=null)
	        	cur.next.prev=cur.prev;
	     // If the node to be deleted is the head node
	        if(head==cur)
	        	head=cur.next;
	        //return the updated head
		 return head;
	 }
	 // Function to delete the last node 
     // of the doubly linked list
	 public static Node deletelast(Node head) {
		 if (head == null) {
			 //if linkedlist is empty
	            return null;
	        }
	        if (head.next == null) {
	            //if theres only one element in list
	        	return null;
	        }

		 Node cur =head;
		 //iterate over to find the last node
		 while(cur.next!=null) {
			 cur=cur.next;
		 }
		// Update the previous node's next pointer
		 if(cur.prev!=null)
			 cur.prev.next=null;
		 // Return the updated head
		 return head;
	 }
	 
	public static void main(String[] args) {
		
        // 2 <-> 3 <-> 4
		Node head =new Node(2);
		head.next = new Node(3);
		head.next.prev =head;
		head.next.next= new Node(4);
		head.next.next.prev = head.next;
		// Print the original list
		System.out.println("Original list");
	    printlist(head);
	    // Insert a new node at the front of the list
	    System.out.println("Inserting a new node at the front");
	    int data =1;
	   head = insertAtFront(head,data);
	   // Print the updated list
	   printlist(head);
	   
        // Print the original list
        //System.out.print("Original Linked List:");
       // printlist(head);

        // Insert a new node after node with data 1
       // System.out.print("Inserting Node with data 2 after node 1 :");
        //int data = 3;
        //int key = 2;
        //key is the specific node
        //which after the new node will be added
        //head = insertAfter(head, key, data);

        // Print the updated list
        printlist(head);

        // Print the original list
        System.out.print("Original Linked List: ");
        printlist(head);

        // Insert a new node before node with data 3
        System.out.print(
            "Inserting Node with data 2 before node 3: ");
        int data2 = 2;
        int key = 3;
        head = insertBefore(head, key, data2);

        // Print the updated list
        printlist(head);

        // Print the original list
        System.out.print("Original Linked List: ");
        printlist(head);

        // Insert new node with data 3 at position 3
        System.out.print("Inserting Node with data 3 at position 3: ");
        int pos = 3;
        head = insertAtPosition(head, pos, data);

        // Print the updated list
        printlist(head);

        // Print the original list
        System.out.println("Original Linked List: ");
        printlist(head);

        // Insert a new node with data 4 at the end
        System.out.println("Inserting Node with data 4 at the end: ");
        head = insertAtEnd(head, data);

        // Print the updated list
        printlist(head);

        head = deleteHead(head);
        printlist(head);
 
        head = deleteAfter(head, 2);
        printlist(head);

        head = deleteBefore(head, 3);
        printlist(head);
	    
        head = deleteAtPosition(head, 2);
        head = deletelast(head);

        printlist(head);
       
	}
}
