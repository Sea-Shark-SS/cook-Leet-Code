package Medium3;

public class RotateList {
	
 static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
 public static ListNode rotateRight(ListNode head, int k) {
     if (head == null || head.next == null || k == 0) {
         return head; // No rotation needed
     }

     // Step 1: Determine the length of the list
     ListNode current = head;
     int length = 1; // Start with 1 to count the head
     while (current.next != null) {
         current = current.next;
         length++;
     }

     // Step 2: Normalize k
     k = k % length;
     if (k == 0) {
         return head; // No rotation needed
     }

     // Step 3: Find the new tail and new head
     current.next = head; // Connect the tail to the head to make it circular
     int newTailPosition = length - k; // Position of the new tail
     ListNode newTail = head;

     for (int i = 1; i < newTailPosition; i++) {
         newTail = newTail.next;
     }

     // Step 4: Set the new head and break the circle
     ListNode newHead = newTail.next;
     newTail.next = null; // Break the circle

     return newHead;
 }

 public static void main(String[] args) {
     // Example usage
     

     // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
     ListNode head = new ListNode(1);
     head.next = new ListNode(2);
     head.next.next = new ListNode(3);
     head.next.next.next = new ListNode(4);
     head.next.next.next.next = new ListNode(5);

     // Rotate the list by k = 2
     ListNode rotatedHead = rotateRight(head, 2);

     // Print the rotated list
     ListNode current = rotatedHead;
     while (current != null) {
         System.out.print(current.val + " ");
         current = current.next;
     }
     // Output: 4 5 1 2 3
 }
}
