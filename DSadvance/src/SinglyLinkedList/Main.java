package SinglyLinkedList;

public class Main {
	public static Node insertAtFirst(Node head,int newData) {
		if(head==null) {
			return head;
			//if list is empty
		}
		//create a new node
		Node cur = new Node(newData);
		cur.next=head;
		head=cur;
		//Big-O(1)
		return head;
	}
	public static Node insertBefore(Node head,int key,int newData) {
		if(head==null) {
			return head;
		}
		if(head.data==key) {
			Node newNode = new Node(newData);
			newNode.next=head;
			head=newNode;
			return head;
		}else {
		Node cur =head;
		Node prev = null;
		
		while(cur!=null && cur.data!=key) {
			prev=cur;
			cur=cur.next;
		}
		// If the key was found
		if(cur!=null) {
			Node newNode = new Node(newData);
			prev.next=newNode;
			newNode.next=cur;
		}
			return head;
		}
	}
	public static Node insertAfter(Node head,int key,int newData) {
		if(head==null)
			return head;
		if(head.data==key) {
			Node newNode = new Node(newData);
			newNode.next=head.next;
			head.next=newNode;
			return head;
		}
		else {
			Node cur = head;
			while(cur!=null) {
				if(cur.data==key) {
					break;
				}
				cur=cur.next;
			}
			Node newNode = new Node(newData);
			newNode.next=cur.next;
			cur.next=newNode;
			
		  return head;	
		}
		
	}
	public static Node insertAtPosition(Node head,int pos , int newData) {
		if(head==null)
			return head;
		if(pos==1) {
			Node newNode=  new Node(newData);
			newNode.next=head;
			head=newNode;
			return head;
		}else {
			Node cur = head;
			//iterate to find the position
			for(int i = 1; i<pos-1 && cur!=null;i++) {
				cur=cur.next;
			}
			//if position is out of bounds
			if(cur==null)
				return head;
			Node newNode=new Node(newData);
			newNode.next=cur.next;
			cur.next=newNode;
			return head;
		}
	}
	public static Node insertEnd(Node head,int newData) {
		if(head==null)
			return head;
		Node cur = head;
		while(cur.next!=null) {
			cur=cur.next;
		}
		Node newNode = new Node(newData);
		cur.next=newNode;
		newNode.next=null;
		return head;
	}
	public static Node deleteAtFirst(Node head) {
		if(head==null)
			return head;
		head=head.next;
		return head;
	}
	public static Node deleteAtPosition(Node head,int pos) {
		if(head==null)
			return head;
		Node cur = head;
		Node temp = null;
		for(int i=1;i<pos && cur!=null;i++) {
			if(i==pos-1) {
			 temp = cur;
				cur=cur.next;
			}else {
				cur=cur.next;
			}
		}
		if(cur==null)
			return head;
		
		temp.next=cur.next;
		return head;
	}
	public static Node deleteAtLast(Node head) {
		if(head==null)
			return head;
		 // If the list has only one node, delete it and
        // return null
        if (head.next == null) {
            return null;
        }
		Node cur = head;
		while(cur.next.next!=null) {
			cur=cur.next;
		}
		cur.next=null;
		
		return head;
	}
	public static void treverse(Node head,int count) {
	       if(head==null)
	    	return;
	       count++;
	       System.out.println(head.data+" ");
	       treverse(head.next,count);//big-O(1)
	    }
	public static boolean search(Node head,int key) {
		//if list is empty
		if(head==null)
			return false;
		//if list has only one element
		if(head.data==key) {
		    return true;	
		}
		Node cur =head;
		while(cur.next!=head) {
			if(cur.data==key) {
				return true;
			}
			cur=cur.next;
		}
		return false;
	}
	public static Node reverseOrder(Node head) {
		Node prev=null;
		Node cur=head;
		Node next;
		//if List is empty
		if(head==null)
			return null;
		//if list has one node
		if(head.next==null)
			return head;
		// Traverse all the nodes of Linked List
		while(cur!=null) {
			// Store next
			next= cur.next;
			// Reverse current node's next pointer
			cur.next=prev;
			// Move pointers one position ahead
			prev=cur;
			cur=next;
		}
		
		return prev;
	}
		
		public static void print(Node head) {
	    	System.out.print(head.data+" ");
	    	if(head.next!=null)
	    		print(head.next);
	    	else
	    		System.out.println();
	    }
	public static int size(Node head) {
		int size=0;
		Node cur=head;
		while(cur!=null) {
			cur=cur.next;
			size++;
		}
		return size;
	}
		public static void main(String[] args) {
			//creation of singly linked list
			Node head = new Node(1);
			head.next = new Node(2);
			head.next.next=new Node(3);
			head.next.next.next=new Node(4);
			System.out.println("Original LinkedList");
			print(head);
			//treverse(head);
		    int data=4;
			//int key=3;
			//int pos = 3;
			//head=insertAtFirst(head,data);
			//head=insertBefore(head,key,data);
			//head=insertAfter(head,key,data);
			//head=insertAtPosition(head,pos,data);
			//head=insertEnd(head,data);
			//head=deleteAtFirst(head);
			//System.out.println("After deleting at first");
			int pos =5;
			System.out.println("Ater delete at position "+pos);
			head=deleteAtPosition(head,pos);
			//head=deleteAtLast(head);
			//System.out.println("After delete at last method");
			print(head);
			//System.out.println(data+" is on the List?");			
		    //System.out.println(search(head,data));
		    System.out.println("After reverseOrder");
		    head=reverseOrder(head);
		    print(head);
		}
}
