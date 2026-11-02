package StackStructure;

public class Stacks {
  int top;
  int[] array;
  int capacity;
  public Stacks(int capacity){
	  this.capacity=capacity;
	  top=-1;
	  array = new int[this.capacity];
	}
  boolean isEmpty() {
	  return(top<0);
  }
  boolean isFull() {
	  return (top==capacity-1);
  }
  void push(int item) {
	  if(top>=capacity-1)
		  System.out.println("Stacks overflow");
	  top++;
	  array[top]=item;
	  
	  System.out.println(item+" pushed in stack");
  }
  int pop() {
	  if(top<0)
		  System.out.println("Stacks underflow");
	  int item = array[top];
	 top--;
	  return item;
  }
  void display() {
	  for(int i = 0 ; i<=top;i++) {
		  System.out.print(array[i]+" ");
	  }
	  System.out.println();
  }
  void top() {
	  if(top<0)
		  System.out.println("Stacks underflow");
	  System.out.println(array[top]);
  }
}
