package CircularLinkedList;

public class Main {
	// Function to insert a node into an empty
    // circular singly linked list
	public static Node insertAtEmptyList(Node last,int newData) {
		 if (last != null)
			 return last;

	        // Create a new node
	        Node newNode = new Node(newData);

	        // Point newNode to itself
	        newNode.next = newNode;

	        // Update last to point to the new node
	        last = newNode;
	        return last;
	}
	 // Function to insert a node at the beginning of the
    // circular linked list
	public static Node insertAtFront(Node last,int newData) {
		Node newNode = new Node(newData);
		// If the list is empty, make the new node point to
        // itself and set it as last
		if(last==null)
		{
			newNode.next=newNode;
			return newNode;
		}
		// Insert the new node at the beginning
		newNode.next=last.next;
		last.next=newNode;
		return last;
	}
	public static void print(Node last) {
		if(last==null) {
			return;
		}
		// Start from the head node
		Node head = last.next;
		while(true) {
			System.out.print(head.data+" ");
			head=head.next;
			if(head==last.next)
				break;
		}
		System.out.println();
	}
	public static Node insertAtLast(Node last,int newData) {
		Node newNode = new Node(newData);
		if(last==null) {
			//if list is empty then make new node at front
			last=newNode;
			return last;
		}else {
			newNode.next=last.next;
			last.next=newNode;
			last=newNode;
			return last;
		}
	}
	public static Node insertAtPosition(Node last,int newData,int pos) {
		if(last == null) {
			//if list is empty
			if(pos!=1) {
				System.out.println("Position is invalid");
			return last;
			}
			Node newNode = new Node(newData);
			last=newNode;
			last.next=last;
					
			return last;
		}
		Node newNode = new Node(newData);
		// curr will point to head initially
		Node cur = last.next;
		 if (pos == 1) {
	            // Insert at the beginning
	            newNode.next = cur;
	            last.next = newNode;
	            return last;
	        }
		// Traverse the list to find the insertion point
		 for(int i=1; i<pos-1 ; i++) {
			 cur=cur.next;
			// If position is out of bounds
			 if(cur==last.next) {
				 return last;
			 }
		 }
		 
		// Insert the new node at the desired position
		 newNode.next=cur.next;
		 cur.next=newNode;
		 // Update last if the new node is inserted at the
	        // end
		 if (cur == last)
	            last = newNode;

	        return last;
		 
		
	}
	public static Node deleteAtFirst(Node last){
	      if (last == null) {
	          // If the list is empty
	          System.out.println("List is empty");
	          return null;
	      }

	        Node temp= last.next;
	       if(temp==last){
	           // If there is only one node in the list
	           return null;
	       }
	       last.next=temp.next;
	        return last;
	  }
	public static Node deleteAtPosition(Node last , int pos){
        if(last==null)
            return last;
        Node cur = last.next;
        for(int i =1 ; i<pos-1;i++){
            cur=cur.next;
            if(cur==last){
                System.out.println("Position out of bound");
            }

        }
        if(pos==1){
            //is delete the first node
            last.next=cur.next;
        }
        else{
            Node temp =cur.next;
            cur.next=temp.next;
        }
        return last;
  }
	public static Node deleteSpecificNode(Node last,int key){
        //if list is empty
        if(last==null)
            return null;
        Node cur=last.next;
        Node prev = last;

      // If the node to be deleted is the only node in the
      // list
      if (cur == last && cur.data == key) {
          last = null;
          return last;
      }
      // If the node to be deleted is the first node
      if(cur.data==key){
          prev.next=cur.next;
          return last;
      }


      while(cur!=last  && cur.data != key){
          prev=cur;
          cur=cur.next;
        }
      if(cur.data==key){
          prev.next=cur.next;
          if(cur==last)
              last=prev;
      }else{
          System.out.println("Data not found");
      }

        return last;
  }
	public static Node deleteAtLast(Node last){
	      if(last==null)
	          return null;
	      //if list is empty
	      Node head = last.next;

	      //if there is only one node in the list
	      if(head==last){
	          last=null;
	          return last;
	      }

	      while(head.next!=last){
	          head=head.next;
	      }
	     head.next=last.next;
	      last=head;
	      return last;
	  }
	public static boolean searchAtList(Node last,int data){
	      if(last==null)
	          return false;
	      Node cur=last.next;
	     
	      while(cur!=last){
	          if(cur.data==data){
	              //key found
	              return true;
	          }else{
	              cur=cur.next;
	          }
	      }
	      // Check the last node
	      if (last.data == data) {
	          // Key found
	          return true;
	      }
	      return false;
	  }
	
    public static void main(String[] args){
    	//Node last = null;
    	int data =1;
    	//last = insertAtEmptyList(last,data);
    	
    	Node first = new Node(2);
        first.next = new Node(3);
        first.next.next = new Node(4);
        Node last = first.next.next;
        last.next = first;
    	System.out.println("Original Linkedlist");
        print(last);
       // last=insertAtFront(last,data);
        //System.out.println("after inserting at the front");
        //last = insertAtLast(last,data);
        //System.out.println("After inserting at last");
        int pos=2;
        
        //System.out.println("after inserting "+data+" at "+pos+" position ");
        //last=insertAtPosition(last,data,pos);
        //print(last);
        //System.out.println("After deleting thr first Node");
        //last=deleteAtFirst(last);
        //print(last);
        //System.out.println("After deleting the last Node");
        //last = deleteAtLast(last);
        //print(last);
        //System.out.println("After deleting at position "+pos);
        //last=deleteAtPosition(last,pos);
        //print(last);
        //System.out.println("After deleting specific Node");
        //last=deleteSpecificNode(last,data);
        //print(last);
        //search in the list
        //System.out.println(data+" is on list ?");
        //System.out.println(searchAtList(last,data));
        
        print(last);
        
    }
}
