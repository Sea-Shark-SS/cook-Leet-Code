package QueueStructure;

public class Main {
public static void main(String[] args) {
	QueueS q1 =  new QueueS(5);
	q1.enqueue(25);
	q1.enqueue(35);
	q1.enqueue(45);
	q1.enqueue(55);
	q1.enqueue(65);
	q1.display();
	System.out.println(q1.isEmpty(q1));
	System.out.println(q1.isFull(q1));
	System.out.println(q1.dequeue());
	System.out.println(q1.capacity);
	System.out.println(q1.peek());
	System.out.println(q1.rear());
}
}
