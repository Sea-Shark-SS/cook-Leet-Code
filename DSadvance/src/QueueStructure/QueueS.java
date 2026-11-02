package QueueStructure;

public class QueueS {
   int front,rear,size;
   int capacity;
   int[] array;
   // public constructor of a queue
   public QueueS(int capacity) {
	  this.capacity=capacity;
	  front = this.size=0;
	  rear = capacity-1;
	  array = new int[this.capacity];
   }
   //Queue becomes full when size is equal to capacity
   boolean isFull(QueueS queue) {
	   return (queue.size==queue.capacity);
   }
   boolean isEmpty(QueueS queue) {
	   return (queue.size==0);
   }
   //return true if size of queue is empty or zero
   void enqueue(int item) {
	   //method to push or insert an element in queue
	   if(isFull(this)) {
		   return;
	   }
	   this.rear= (this.rear+1)%this.capacity;
	   this.array[rear] = item;//insert item in rear index of out array
	   this.size++;
	   //System.out.println(item+" enqueued in queue");
   }
   int dequeue() {
	   //method to delete an item from the front
	   if(isEmpty(this))
		   return Integer.MIN_VALUE;
	   int item = this.array[this.front];
	   this.front= (this.front+1)%capacity;
	   this.size--;
	   return item;
	   
   }
   int peek() {
	   if(isEmpty(this)) {
		   return Integer.MIN_VALUE;
	   }
	   return this.array[this.front];
   }
   //peeks the first element
   int rear() {
	   if(isEmpty(this)) {
		   return Integer.MIN_VALUE;
	   }
	   return this.array[this.rear];
   }
   //shows the rear element
   void display() {
	   System.out.print("[");
	   for(int i=0 ; i<capacity;i++) {
		   System.out.print(array[i]+" ");
	   }
	   System.out.print("]");
	   System.out.println();
   }
 
}
