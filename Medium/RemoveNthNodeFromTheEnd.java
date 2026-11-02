package Medium;



public class RemoveNthNodeFromTheEnd {
static class ListNode{
	int data;
	ListNode next;
	ListNode(int data){
		this.data=data;
		this.next=null;
	}
}
public static int size(ListNode head) {
	int size=0;
	ListNode cur=head;
	while(cur!=null) {
		cur=cur.next;
		size++;
	}
	return size;
}
public static ListNode removeNthFromEnd(ListNode head,int pos) {
	pos=size(head)-pos;
	if(pos==1) {
		head=head.next;
		return head;
	}
	if(head==null)
		return head;
	ListNode cur = head;
	ListNode temp = null;
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
static void print(ListNode head) {
while(head!=null) {
	System.out.print(head.data+" ");
	head=head.next;
}
}

public static void main(String[] args) {
	ListNode head= new ListNode(1);
	head.next=new ListNode(2);
	head.next.next = new ListNode(3);
	System.out.println(size(head));
	print(head);
	System.out.println();
	head=removeNthFromEnd(head,2);
	print(head);
}
}
