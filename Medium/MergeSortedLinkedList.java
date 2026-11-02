package Medium;


public class MergeSortedLinkedList {
	static class ListNode{
			int data;
			ListNode next;
			ListNode(int data){
				this.data=data;
				this.next=null;
			}
		}
	
public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
	 // Create a dummy node to simplify the merging process
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;

    // Traverse both lists
    while (list1 != null && list2 != null) {
        if (list1.data < list2.data) {
            current.next = list1; // Append list1 node
            list1 = list1.next;    // Move to the next node in list1
        } else {
            current.next = list2; // Append list2 node
            list2 = list2.next;    // Move to the next node in list2
        }
        current = current.next; // Move the current pointer
    }

    // If there are remaining nodes in either list, append them
    if (list1 != null) {
        current.next = list1;
    } else if (list2 != null) {
        current.next = list2;
    }

    // Return the merged list, which starts from the next of dummy node
    return dummy.next;
    }
	static void print(ListNode head) {
		while(head!=null) {
			System.out.print(head.data+ " ");
			head=head.next;
		}
	}
public static void main(String[] args) {
	ListNode list1 = new ListNode(1);
	list1.next=new ListNode(2);
	list1.next.next=new ListNode(4);
	ListNode list2 = new ListNode(1);
	list1.next=new ListNode(2);
	list1.next.next=new ListNode(3);
	ListNode mergelist=mergeTwoLists(list1,list2);
	print(mergelist);
	
}
}
