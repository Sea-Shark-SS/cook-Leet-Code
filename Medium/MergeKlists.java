package Medium;

import java.util.PriorityQueue;

public class MergeKlists {
	
	static class ListNode {
	    int val;
	    ListNode next;
	    ListNode(int x) { val = x; }
	}
	public static ListNode mergeKLists(ListNode[] lists) {
        // Create a priority queue (min-heap)
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        // Add the head of each linked list to the min-heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        // Create a dummy head for the merged linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        // Merge the linked lists
        while (!minHeap.isEmpty()) {
            // Get the smallest node from the heap
            ListNode smallestNode = minHeap.poll();
            current.next = smallestNode; // Add it to the merged list
            current = current.next; // Move to the next position
            
            // If there is a next node, add it to the heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }
        
        return dummy.next; // Return the merged linked list
    }

    public static void main(String[] args) {
        // Example usage
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);
        
        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);
        
        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);
        
        
        ListNode mergedList = mergeKLists(lists);
        
        // Print the merged linked list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
}
}
